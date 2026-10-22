package org.apache.commons.compress.archivers.tar;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.locallife.pdp.album.model.CustomAlbumViewModel;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.ttm.player.MediaPlayer;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.utils.ArchiveUtils;

/* JADX INFO: loaded from: classes42.dex */
public class TarArchiveEntry implements ArchiveEntry {
    private static final TarArchiveEntry[] EMPTY_TAR_ARCHIVE_ENTRIES = null;
    private boolean checkSumOK;
    private int devMajor;
    private int devMinor;
    private final Map<String, String> extraPaxHeaders;
    private final File file;
    private long groupId;
    private String groupName;
    private boolean isExtended;
    private byte linkFlag;
    private String linkName;
    private String magic;
    private long modTime;
    private int mode;
    private String name;
    private boolean paxGNUSparse;
    private final boolean preserveAbsolutePath;
    private long realSize;
    private long size;
    private boolean starSparse;
    private long userId;
    private String userName;
    private String version;

    static {
        EMPTY_TAR_ARCHIVE_ENTRIES = new TarArchiveEntry[0];
    }

    public boolean isDirectory() {
        File r100 = this.file;
        if (r100 == null) goto L7;
        return r100.isDirectory();
    L7:
        if (this.linkFlag != 53) goto L10;
        return true;
    L10:
        if (isPaxHeader() == false) goto L12;
    L16:
        return false;
    L12:
        if (isGlobalPaxHeader() == true) goto L16;
        if (getName().endsWith(HTTP.URL_DEFAULT) == false) goto L16;
        return true;
    }

    public boolean isGNULongLinkEntry() {
        if (this.linkFlag != 75) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isGNULongNameEntry() {
        if (this.linkFlag != 76) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isGlobalPaxHeader() {
        if (this.linkFlag != 103) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isOldGNUSparse() {
        if (this.linkFlag != 83) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isPaxHeader() {
        byte r100 = this.linkFlag;
        if (r100 != 120) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 88) goto L8;
        return false;
    }

    public int hashCode() {
        return getName().hashCode();
    }

    public String getName() {
        return this.name;
    }

    public long getSize() {
        return this.size;
    }

    public boolean isExtended() {
        return this.isExtended;
    }

    private TarArchiveEntry(boolean r100) {
        this.name = "";
        this.userId = 0;
        this.groupId = 0;
        this.size = 0;
        this.linkName = "";
        this.magic = "ustar\u0000";
        this.version = CustomAlbumViewModel.DEFAULT_TAB_ID;
        this.groupName = "";
        this.devMajor = 0;
        this.devMinor = 0;
        this.extraPaxHeaders = new HashMap();
        String r101 = System.getProperty("user.name", "");
        if (r101.length() <= 31) goto L5;
        r101 = r101.substring(0, 31);
    L5:
        this.userName = r101;
        this.file = null;
        this.preserveAbsolutePath = r100;
    }

    private int evaluateType(byte[] r100) {
        if (ArchiveUtils.matchAsciiBuffer("ustar ", r100, 257, 6) == false) goto L7;
        return 2;
    L7:
        if (ArchiveUtils.matchAsciiBuffer("ustar\u0000", r100, 257, 6) == true) goto L9;
        return 0;
    L9:
        if (ArchiveUtils.matchAsciiBuffer("tar\u0000", r100, 508, 4) == false) goto L11;
        return 4;
    L11:
        return 3;
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L4;
        return false;
    L4:
        if (getClass() == r100.getClass()) goto L7;
        return false;
    L7:
        return equals((TarArchiveEntry) r100);
    }

    public void fillGNUSparse0xData(Map<String, String> r100) {
        this.paxGNUSparse = true;
        this.realSize = CastIntegerProtector.parseInt(r100.get("GNU.sparse.size"));
        if (r100.containsKey("GNU.sparse.name") == false) goto L6;
        this.name = r100.get("GNU.sparse.name");
        return;
    }

    public void fillGNUSparse1xData(Map<String, String> r100) {
        this.paxGNUSparse = true;
        this.realSize = CastIntegerProtector.parseInt(r100.get("GNU.sparse.realsize"));
        this.name = r100.get("GNU.sparse.name");
    }

    public void fillStarSparseData(Map<String, String> r100) {
        this.starSparse = true;
        if (r100.containsKey("SCHILY.realsize") == false) goto L6;
        this.realSize = CastLongProtector.parseLong(r100.get("SCHILY.realsize"));
        return;
    }

    public void setDevMajor(int r100) {
        if (r100 < 0) goto L6;
        this.devMajor = r100;
        return;
    L6:
        throw new IllegalArgumentException("Major device number is out of range: " + r100);
    }

    public void setDevMinor(int r100) {
        if (r100 < 0) goto L6;
        this.devMinor = r100;
        return;
    L6:
        throw new IllegalArgumentException("Minor device number is out of range: " + r100);
    }

    public void setGroupId(long r100) {
        this.groupId = r100;
    }

    public void setGroupName(String r100) {
        this.groupName = r100;
    }

    public void setLinkName(String r100) {
        this.linkName = r100;
    }

    public void setModTime(long r100) {
        this.modTime = r100 / 1000;
    }

    public void setName(String r100) {
        this.name = normalizeFileName(r100, this.preserveAbsolutePath);
    }

    public void setSize(long r100) {
        if (r100 < 0) goto L7;
        this.size = r100;
        return;
    L7:
        throw new IllegalArgumentException("Size is out of range: " + r100);
    }

    public void setUserId(long r100) {
        this.userId = r100;
    }

    public void setUserName(String r100) {
        this.userName = r100;
    }

    public void updateEntryFromPaxHeaders(Map<String, String> r100) {
        Iterator<Map.Entry<String, String>> r101 = r100.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Map.Entry<String, String> r102 = r101.next();
        processPaxHeader(r102.getKey(), r102.getValue(), r100);
        goto L4
    }

    public boolean equals(TarArchiveEntry r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (getName().equals(r100.getName()) == false) goto L6;
        return true;
    }

    public TarArchiveEntry(byte[] r100, ZipEncoding r101) throws IOException {
        this(false);
        parseTarHeader(r100, r101);
    }

    private static String normalizeFileName(String r100, boolean r101) {
        if (r101 == true) goto L26;
        String r102 = System.getProperty("os.name").toLowerCase(Locale.ENGLISH);
        if (r102 == null) goto L26;
        if (r102.startsWith("windows") == false) goto L22;
        if (r100.length() <= 2) goto L26;
        char r103 = r100.charAt(0);
        if (r100.charAt(1) != ':') goto L26;
        if (r103 < 'a') goto L17;
        if (r103 > 'z') goto L17;
    L20:
        r100 = r100.substring(2);
    L17:
        if (r103 < 'A') goto L26;
        if (r103 > 'Z') goto L26;
    L22:
        if (r102.contains("netware") == false) goto L26;
        int r104 = r100.indexOf(58);
        if (r104 == (-1)) goto L26;
        r100 = r100.substring(r104 + 1);
    L26:
        String r105 = r100.replace(File.separatorChar, '/');
    L27:
        if (r101 == true) goto L31;
        if (r105.startsWith(HTTP.URL_DEFAULT) == false) goto L31;
        r105 = r105.substring(1);
    L31:
        return r105;
    }

    public void parseTarHeader(byte[] r100, ZipEncoding r101) throws IOException {
        parseTarHeader(r100, r101, false);
    }

    private void parseTarHeader(byte[] r100, ZipEncoding r101, boolean r102) throws IOException {
        if (r102 == false) goto L5;
        String r103 = TarUtils.parseName(r100, 0, 100);
    L6:
        this.name = r103;
        this.mode = (int) TarUtils.parseOctalOrBinary(r100, 100, 8);
        this.userId = (int) TarUtils.parseOctalOrBinary(r100, 108, 8);
        this.groupId = (int) TarUtils.parseOctalOrBinary(r100, 116, 8);
        this.size = TarUtils.parseOctalOrBinary(r100, 124, 12);
        this.modTime = TarUtils.parseOctalOrBinary(r100, 136, 12);
        this.checkSumOK = TarUtils.verifyCheckSum(r100);
        this.linkFlag = r100[156(0x9c, float:2.19E-43)];
        if (r102 == false) goto L9;
        String r104 = TarUtils.parseName(r100, 157, 100);
    L10:
        this.linkName = r104;
        this.magic = TarUtils.parseName(r100, 257, 6);
        this.version = TarUtils.parseName(r100, MediaPlayer.MEDIA_PLAYER_OPTION_DELAY_BUFFERING_UPDATE, 2);
        if (r102 == false) goto L13;
        String r105 = TarUtils.parseName(r100, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_TRAN_CONNECT_TIME, 32);
    L14:
        this.userName = r105;
        if (r102 == false) goto L17;
        String r106 = TarUtils.parseName(r100, MediaPlayer.MEDIA_PLAYER_OPTION_SKIP_BUFFER_LIMIT, 32);
    L18:
        this.groupName = r106;
        byte r107 = this.linkFlag;
        if (r107 != 51) goto L21;
    L22:
        this.devMajor = (int) TarUtils.parseOctalOrBinary(r100, 329, 8);
        this.devMinor = (int) TarUtils.parseOctalOrBinary(r100, 337, 8);
    L23:
        int r108 = evaluateType(r100);
        if (r108 != 2) goto L26;
        this.isExtended = TarUtils.parseBoolean(r100, 482);
        this.realSize = TarUtils.parseOctal(r100, 483, 12);
        return;
    L26:
        if (r108 == 4) goto L40;
        if (r102 == false) goto L30;
        String r109 = TarUtils.parseName(r100, 345, 155);
    L32:
        if (isDirectory() == false) goto L37;
        if (this.name.endsWith(HTTP.URL_DEFAULT) == true) goto L37;
        this.name += HTTP.URL_DEFAULT;
    L37:
        if (r109.length() <= 0) goto L48;
        this.name = r109 + HTTP.URL_DEFAULT + this.name;
        return;
    L48:
        return;
    L30:
        r109 = TarUtils.parseName(r100, 345, 155, r101);
        goto L32
    L40:
        if (r102 == false) goto L42;
        String r110 = TarUtils.parseName(r100, 345, 131);
    L44:
        if (r110.length() <= 0) goto L50;
        this.name = r110 + HTTP.URL_DEFAULT + this.name;
        return;
    L50:
        return;
    L42:
        r110 = TarUtils.parseName(r100, 345, 131, r101);
        goto L44
    L21:
        if (r107 != 52) goto L23;
    L17:
        r106 = TarUtils.parseName(r100, MediaPlayer.MEDIA_PLAYER_OPTION_SKIP_BUFFER_LIMIT, 32, r101);
        goto L18
    L13:
        r105 = TarUtils.parseName(r100, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_TRAN_CONNECT_TIME, 32, r101);
        goto L14
    L9:
        r104 = TarUtils.parseName(r100, 157, 100, r101);
        goto L10
    L5:
        r103 = TarUtils.parseName(r100, 0, 100, r101);
        goto L6
    }

    private void processPaxHeader(String r100, String r101, Map<String, String> r102) {
        r100.getClass();
        byte r103 = -1;
        switch(r100.hashCode()) {
            case -1916861932: goto L54;
            case -1916619760: goto L50;
            case -277496563: goto L46;
            case -160380561: goto L42;
            case 102338: goto L38;
            case 115792: goto L34;
            case 3433509: goto L30;
            case 3530753: goto L26;
            case 98496370: goto L22;
            case 104223930: goto L18;
            case 111425664: goto L14;
            case 530706950: goto L10;
            case 1195018015: goto L6;
            default: goto L57;
        };
    L57:
        switch(r103) {
            case 0: goto L73;
            case 1: goto L72;
            case 2: goto L71;
            case 3: goto L70;
            case 4: goto L69;
            case 5: goto L68;
            case 6: goto L67;
            case 7: goto L66;
            case 8: goto L65;
            case 9: goto L64;
            case 10: goto L63;
            case 11: goto L61;
            case 12: goto L59;
            default: goto L58;
        };
    L58:
        this.extraPaxHeaders.put(r100, r101);
        return;
    L59:
        setLinkName(r101);
        return;
    L63:
        setUserName(r101);
        return;
    L64:
        setModTime((long) (CastDoubleProtector.parseDouble(r101) * 1000.0d));
        return;
    L65:
        setGroupName(r101);
        return;
    L66:
        setSize(CastLongProtector.parseLong(r101));
        return;
    L67:
        setName(r101);
        return;
    L68:
        setUserId(CastLongProtector.parseLong(r101));
        return;
    L69:
        setGroupId(CastLongProtector.parseLong(r101));
        return;
    L70:
        fillGNUSparse0xData(r102);
        return;
    L71:
        fillGNUSparse1xData(r102);
        return;
    L72:
        setDevMinor(CastIntegerProtector.parseInt(r101));
        return;
    L73:
        setDevMajor(CastIntegerProtector.parseInt(r101));
        return;
    L61:
        if ("sparse".equals(r101) == false) goto L77;
        fillStarSparseData(r102);
        return;
    L77:
        return;
    L6:
        if (r100.equals("linkpath") == false) goto L57;
        r103 = 12;
        goto L57
    L10:
        if (r100.equals("SCHILY.filetype") == false) goto L57;
        r103 = 11;
        goto L57
    L14:
        if (r100.equals("uname") == false) goto L57;
        r103 = 10;
        goto L57
    L18:
        if (r100.equals("mtime") == false) goto L57;
        r103 = 9;
        goto L57
    L22:
        if (r100.equals("gname") == false) goto L57;
        r103 = 8;
        goto L57
    L26:
        if (r100.equals("size") == false) goto L57;
        r103 = 7;
        goto L57
    L30:
        if (r100.equals("path") == false) goto L57;
        r103 = 6;
        goto L57
    L34:
        if (r100.equals("uid") == false) goto L57;
        r103 = 5;
        goto L57
    L38:
        if (r100.equals("gid") == false) goto L57;
        r103 = 4;
        goto L57
    L42:
        if (r100.equals("GNU.sparse.size") == false) goto L57;
        r103 = 3;
        goto L57
    L46:
        if (r100.equals("GNU.sparse.realsize") == false) goto L57;
        r103 = 2;
        goto L57
    L50:
        if (r100.equals("SCHILY.devminor") == false) goto L57;
        r103 = 1;
        goto L57
    L54:
        if (r100.equals("SCHILY.devmajor") == false) goto L57;
        r103 = 0;
        goto L57
    }
}
