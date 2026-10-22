package org.apache.commons.net.ftp;

import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Directory;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Symlink;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes42.dex */
public class FTPFile implements Serializable {
    public static final int DIRECTORY_TYPE = 1;
    public static final int EXECUTE_PERMISSION = 2;
    public static final int FILE_TYPE = 0;
    public static final int GROUP_ACCESS = 1;
    public static final int READ_PERMISSION = 0;
    public static final int SYMBOLIC_LINK_TYPE = 2;
    public static final int UNKNOWN_TYPE = 3;
    public static final int USER_ACCESS = 0;
    public static final int WORLD_ACCESS = 2;
    public static final int WRITE_PERMISSION = 1;
    private static final long serialVersionUID = 9010790363003271996L;
    private Calendar _date;
    private String _group;
    private int _hardLinkCount;
    private String _link;
    private String _name;
    private final boolean[][] _permissions;
    private String _rawListing;
    private long _size;
    private int _type;
    private String _user;

    public String toFormattedString() {
        return toFormattedString(null);
    }

    private char formatType() {
        int r100 = this._type;
        if (r100 != 0) goto L5;
        return '-';
    L5:
        if (r100 != 1) goto L7;
        return Directory.UNIX_ID;
    L7:
        if (r100 == 2) goto L10;
        return '?';
    L10:
        return Symlink.UNIX_ID;
    }

    public boolean isDirectory() {
        if (this._type == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isFile() {
        if (this._type != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isSymbolicLink() {
        if (this._type != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isUnknown() {
        if (this._type != 3) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isValid() {
        if (this._permissions == null) goto L5;
        return true;
    L5:
        return false;
    }

    public FTPFile() {
        Class r100 = Boolean.TYPE;
        this._permissions = (boolean[][]) Array.newInstance(r100, new int[]{3, 3});
        this._type = 3;
        this._hardLinkCount = 0;
        this._size = -1;
        this._user = "";
        this._group = "";
        this._date = null;
        this._name = null;
    }

    public String toString() {
        return getRawListing();
    }

    public String getGroup() {
        return this._group;
    }

    public int getHardLinkCount() {
        return this._hardLinkCount;
    }

    public String getLink() {
        return this._link;
    }

    public String getName() {
        return this._name;
    }

    public String getRawListing() {
        return this._rawListing;
    }

    public long getSize() {
        return this._size;
    }

    public Calendar getTimestamp() {
        return this._date;
    }

    public int getType() {
        return this._type;
    }

    public String getUser() {
        return this._user;
    }

    public FTPFile(String r100) {
        this._permissions = null;
        this._rawListing = r100;
        this._type = 3;
        this._hardLinkCount = 0;
        this._size = -1;
        this._user = "";
        this._group = "";
        this._date = null;
        this._name = null;
    }

    private String permissionToString(int r100) {
        StringBuilder r101 = new StringBuilder();
        if (hasPermission(r100, 0) == false) goto L5;
        r101.append(Permission.READ);
    L7:
        if (hasPermission(r100, 1) == false) goto L9;
        r101.append(Permission.WRITE);
    L11:
        if (hasPermission(r100, 2) == false) goto L13;
        r101.append(Permission.EXECUTE);
    L15:
        return r101.toString();
    L13:
        r101.append('-');
        goto L15
    L9:
        r101.append('-');
        goto L11
    L5:
        r101.append('-');
        goto L7
    }

    public void setGroup(String r100) {
        this._group = r100;
    }

    public void setHardLinkCount(int r100) {
        this._hardLinkCount = r100;
    }

    public void setLink(String r100) {
        this._link = r100;
    }

    public void setName(String r100) {
        this._name = r100;
    }

    public void setRawListing(String r100) {
        this._rawListing = r100;
    }

    public void setSize(long r100) {
        this._size = r100;
    }

    public void setTimestamp(Calendar r100) {
        this._date = r100;
    }

    public void setType(int r100) {
        this._type = r100;
    }

    public void setUser(String r100) {
        this._user = r100;
    }

    public String toFormattedString(String r100) {
        if (isValid() == true) goto L6;
        return "[Invalid: could not parse file entry]";
    L6:
        StringBuilder r101 = new StringBuilder();
        Formatter r102 = new Formatter(r101);
        r101.append(formatType());
        r101.append(permissionToString(0));
        r101.append(permissionToString(1));
        r101.append(permissionToString(2));
        r102.format(" %4d", new Object[]{Integer.valueOf(getHardLinkCount())});
        r102.format(" %-8s %-8s", new Object[]{getUser(), getGroup()});
        r102.format(" %8d", new Object[]{Long.valueOf(getSize())});
        Calendar r103 = getTimestamp();
        if (r103 == null) goto L22;
        if (r100 == null) goto L12;
        TimeZone r104 = TimeZone.getTimeZone(r100);
        if (r104.equals(r103.getTimeZone()) == true) goto L12;
        Date r105 = r103.getTime();
        Calendar r106 = Calendar.getInstance(r104);
        r106.setTime(r105);
        r103 = r106;
    L12:
        r102.format(" %1$tY-%1$tm-%1$td", new Object[]{r103});
        if (r103.isSet(11) == false) goto L22;
        r102.format(" %1$tH", new Object[]{r103});
        if (r103.isSet(12) == false) goto L21;
        r102.format(":%1$tM", new Object[]{r103});
        if (r103.isSet(13) == false) goto L21;
        r102.format(":%1$tS", new Object[]{r103});
        if (r103.isSet(14) == false) goto L21;
        r102.format(".%1$tL", new Object[]{r103});
    L21:
        r102.format(" %1$tZ", new Object[]{r103});
    L22:
        r101.append(' ');
        r101.append(getName());
        r102.close();
        return r101.toString();
    }

    public boolean hasPermission(int r100, int r101) {
        boolean[][] r102 = this._permissions;
        if (r102 != null) goto L7;
        return false;
    L7:
        return r102[r100][r101];
    }

    public void setPermission(int r100, int r101, boolean r102) {
        this._permissions[r100][r101] = r102;
    }
}
