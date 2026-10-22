package com.ss.android.lark.contact.base.entity.mobile;

import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.ImageView;
import android.widget.TextView;
import c9b.a;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.supervisor.token.Token;
import com.larksuite.framework.utils.RomUtils;
import com.ss.android.lark.contact.base.entity.mobile.util.ContactMobileUtils;
import h9b.b;
import java.io.Serializable;
import java.util.ArrayList;
import org.slf4j.Marker;
import ru7.c;

/* JADX INFO: loaded from: classes35.dex */
public class ContactMobileBean implements Comparable<ContactMobileBean>, Serializable {
    private static final long serialVersionUID = -9094813086945219750L;
    private boolean EnableChoose;
    private String mAbbreviation;
    private String mAvatarUri;
    private Pair<Integer, String> mCountryCodePhonePair;
    private String mEmail;
    private String mInitial;
    private String mName;
    private String mPhone;
    private String mPhoneE164;
    private int matchType;
    private String namePinYin;
    private ArrayList<String> namePinyinList;

    public final void a() {
        String r100 = ContactMobileUtils.c(this.mName);
        this.mAbbreviation = r100;
        this.mInitial = r100.substring(0, 1);
        StringBuffer r101 = new StringBuffer();
        StringBuffer r102 = new StringBuffer();
        int r103 = 0;
    L4:
        if (r103 >= this.mName.length()) goto L10;
        StringBuffer r104 = new StringBuffer();
        String r105 = this.mName.charAt(r103) + "";
        int r106 = 0;
    L7:
        if (r106 >= r105.length()) goto L9;
        String r107 = c.c(r105.charAt(r106)).toUpperCase();
        r104.append(r107);
        r102.append(r107.charAt(0));
        r101.append(r107);
        r106 = r106 + 1;
        goto L7
    L9:
        this.namePinyinList.add(r104.toString());
        r103 = r103 + 1;
        goto L4
    L10:
        this.namePinYin = r101.toString();
    }

    public String getAvatarName() {
        if (PatternProtector.compile("[A-Za-z]").matcher(this.mName).find() == false) goto L14;
        String[] r100 = this.mName.split(" ");
        if (r100.length < 2) goto L13;
        if (r100[0].toCharArray().length <= 0) goto L13;
        if (r100[r100.length - 1].toCharArray().length <= 0) goto L13;
        return (r100[0].toCharArray()[0] + "" + r100[r100.length - 1].toCharArray()[0]).toUpperCase();
    L13:
        return (this.mName.toCharArray()[0] + "").toUpperCase();
    L14:
        char[] r101 = this.mName.toCharArray();
        if (r101.length < 2) goto L19;
        return (r101[r101.length - 2] + "" + r101[r101.length - 1]).toUpperCase();
    L19:
        return this.mName.toUpperCase();
    }

    public String getUniquelyIdentifies() {
        return getName() + getEmail() + getPhone();
    }

    public boolean isEmail() {
        return !TextUtils.isEmpty(this.mEmail);
    }

    public String toString() {
        String r100 = "name: " + getName();
        if (isEmail() == false) goto L7;
        return r100 + ", email: " + getEmail();
    L7:
        return r100 + ", phone: " + this.mCountryCodePhonePair;
    }

    public String getEmailOrPhone() {
        if (isEmail() == false) goto L7;
        return getEmail();
    L7:
        return getPhone();
    }

    public String getEmailOrPhoneE164() {
        if (isEmail() == false) goto L7;
        return getEmail();
    L7:
        return getPhoneE164();
    }

    public boolean isAvailable() {
        if (isEmail() == false) goto L7;
        String r100 = this.mEmail;
        Token r101 = ContactMobileUtils.f418890a;
        return b.b("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$", r100);
    L7:
        return ContactMobileUtils.d(this.mCountryCodePhonePair);
    }

    public boolean isRightEmail() {
        if (isEmail() == true) goto L6;
        return false;
    L6:
        String r100 = this.mEmail;
        Token r101 = ContactMobileUtils.f418890a;
        return b.b("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$", r100);
    }

    public boolean isRightPhone() {
        if (isEmail() == false) goto L7;
        return false;
    L7:
        return ContactMobileUtils.d(this.mCountryCodePhonePair);
    }

    public String getAvatarUri() {
        return this.mAvatarUri;
    }

    public String getEmail() {
        return this.mEmail;
    }

    public String getInitial() {
        return this.mInitial;
    }

    public String getName() {
        return this.mName;
    }

    public String getNamePinYin() {
        return this.namePinYin;
    }

    public ArrayList<String> getNamePinyinList() {
        return this.namePinyinList;
    }

    public String getPhone() {
        return this.mPhone;
    }

    public String getPhoneE164() {
        return this.mPhoneE164;
    }

    public Pair<Integer, String> getmCountryCodePhonePair() {
        return this.mCountryCodePhonePair;
    }

    public boolean isEnableChoose() {
        return this.EnableChoose;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(ContactMobileBean r100) {
        if (this.mAbbreviation.equals(r100.mAbbreviation) == false) goto L6;
        return 0;
    L6:
        boolean r101 = this.mAbbreviation.startsWith("#");
        if ((r100.mAbbreviation.startsWith("#") ^ r101) == false) goto L13;
        if (r101 == false) goto L10;
        return 1;
    L10:
        return -1;
    L13:
        return getInitial().compareTo(r100.getInitial());
    }

    public boolean isMatch(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return true;
    L6:
        if (getName().contains(r100) == false) goto L9;
        return true;
    L9:
        if (getEmailOrPhone().contains(r100) == false) goto L12;
        return true;
    L12:
        if (this.namePinYin.contains(r100.toUpperCase()) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public void setEnableChoose(boolean r100) {
        this.EnableChoose = r100;
    }

    public void setMatchType(int r100) {
        this.matchType = r100;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(ContactMobileBean r100) {
        return compareTo2(r100);
    }

    public void cancelLoadAvatar(TextView r100, ImageView r101) {
        if (r100.getTag() == null) goto L6;
        ((AsyncTask) r100.getTag()).cancel(true);
    L6:
        if (r101.getTag() == null) goto L9;
        ((AsyncTask) r101.getTag()).cancel(true);
        return;
    }

    public void loadAvatar(TextView r100, ImageView r101) {
        if (TextUtils.isEmpty(this.mAvatarUri) == false) goto L5;
    L9:
        r100.setText(getAvatarName());
        return;
    L5:
        if (RomUtils.h() == true) goto L9;
        a r102 = new a(r100, r101, this);
        r100.setTag(r102);
        r101.setTag(r102);
        r102.execute1(new Object[0]);
    }

    public ContactMobileBean(String r100, String r101, String r102) {
        this.namePinYin = "";
        this.matchType = 0;
        this.namePinyinList = new ArrayList();
        this.EnableChoose = true;
        this.mName = r100;
        this.mAvatarUri = r101;
        this.mEmail = r102;
        a();
    }

    public ContactMobileBean(String r100, String r101, String r102, Pair<Integer, String> r103) {
        String r104 = "";
        this.namePinYin = "";
        this.matchType = 0;
        this.namePinyinList = new ArrayList();
        this.EnableChoose = true;
        this.mName = r100;
        this.mAvatarUri = r101;
        this.mPhone = r102;
        this.mCountryCodePhonePair = r103;
        if (r103 == null) goto L6;
        r104 = Marker.ANY_NON_NULL_MARKER + this.mCountryCodePhonePair.first + ((String) this.mCountryCodePhonePair.second);
    L6:
        this.mPhoneE164 = r104;
        a();
    }

    public ContactMobileBean(String r100, String r101, int r102, String r103) {
        this(r100, r101, r103, ContactMobileUtils.e(r102, r103));
    }
}
