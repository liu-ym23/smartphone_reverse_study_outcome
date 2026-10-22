package com.ss.android.lark.passport.assemble;

import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.obric.sva.sdk.utils.InteractConst;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.passport.base.core.log.PassportLog;
import com.ss.android.lark.passport.signinsdk_api.account.I18Name;
import com.ss.android.lark.passport.signinsdk_api.account.SessionInfo;
import com.ss.android.lark.passport.signinsdk_api.account.Tenant;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J&\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000fH\u0002J\u001a\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011H\u0002J\u001e\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u001a\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u001a\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u000b\u001a\u00020\fH\u0002¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/passport/assemble/UserTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/ss/android/lark/passport/signinsdk_api/account/User;", "<init>", "()V", "write", "", Argument.OUT, "Lcom/google/gson/stream/JsonWriter;", "user", "read", "reader", "Lcom/google/gson/stream/JsonReader;", "writeSessionInfoMap", "sessionMap", "", "", "Lcom/ss/android/lark/passport/signinsdk_api/account/SessionInfo;", "writeSessionInfo", "sessionInfo", "readSessionInfoMap", "readSessionInfo", "writeI18Name", "i18Name", "Lcom/ss/android/lark/passport/signinsdk_api/account/I18Name;", "readI18Name", "writeTenant", "tenant", "Lcom/ss/android/lark/passport/signinsdk_api/account/Tenant;", "readTenant", "Companion", "passport-officesdk-assembly_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UserTypeAdapter extends TypeAdapter<User> {

    public static final class a {
    }

    static {
    }

    public UserTypeAdapter() {
    }

    public static I18Name a(JsonReader r100) {
        if (r100.peek() != JsonToken.NULL) goto L6;
        r100.nextNull();
        return null;
    L6:
        I18Name r101 = new I18Name();
        r100.beginObject();
    L8:
        if (r100.hasNext() == false) goto L31;
        String r102 = r100.nextName();
        if (r102 == null) goto L30;
        int r103 = r102.hashCode();
        if (r103 != 3117351) goto L14;
        if (r102.equals("enUs") == false) goto L30;
        r101.enUs = r100.nextString();
        goto L8
    L14:
        if (r103 != 3253469) goto L16;
        if (r102.equals("jaJp") == false) goto L30;
        r101.jaJp = r100.nextString();
        goto L8
    L16:
        if (r103 != 3736633) goto L30;
        if (r102.equals("zhCn") == false) goto L30;
        r101.zhCn = r100.nextString();
    L30:
        r100.skipValue();
        goto L8
    L31:
        r100.endObject();
        return r101;
    }

    @Override // com.google.gson.TypeAdapter
    public final User read(JsonReader r110) {
        Intrinsics.checkNotNullParameter(r110, "reader");
        if (r110.peek() != JsonToken.NULL) goto L5;
        r110.nextNull();
        return null;
    L5:
        User r100 = new User();
        r110.beginObject();
    L7:
        if (r110.hasNext() == false) goto L252;
        String r101 = r110.nextName();
        JsonToken r102 = r110.peek();
        JsonToken r103 = JsonToken.NULL;
        if (r102 == r103) goto L10;
        if (r101 == null) goto L251;
        switch(r101.hashCode()) {
            case -2095811475: goto L248;
            case -1882959080: goto L244;
            case -1373324881: goto L240;
            case -1088998220: goto L236;
            case -1042763398: goto L232;
            case -1015178243: goto L228;
            case -917391773: goto L225;
            case -892481550: goto L221;
            case -877336406: goto L160;
            case -836030906: goto L156;
            case -835063588: goto L95;
            case -776171730: goto L92;
            case -686204988: goto L88;
            case -428656058: goto L84;
            case -428646058: goto L80;
            case -266445841: goto L73;
            case -147156090: goto L69;
            case -22433935: goto L66;
            case 3373707: goto L62;
            case 155571963: goto L58;
            case 601559335: goto L55;
            case 888049560: goto L52;
            case 1026270683: goto L48;
            case 1195763197: goto L44;
            case 1287442096: goto L41;
            case 1369213417: goto L37;
            case 1714148973: goto L33;
            case 1719507599: goto L29;
            case 1741059462: goto L26;
            case 1984987798: goto L22;
            case 2059605615: goto L19;
            case 2084791044: goto L16;
            default: goto L251;
        };
    L19:
        if (r101.equals("suite_session_key") == false) goto L251;
    L24:
        r100.setSession(r110.nextString());
        goto L7
    L22:
        if (r101.equals(AppbrandHostConstants.SCHEMA_INSPECT.SESSION) == true) goto L24;
    L26:
        if (r101.equals("suite_session_key_with_domains") == false) goto L251;
    L98:
        if (r110.peek() != r103) goto L100;
        r110.nextNull();
        LinkedHashMap r104 = null;
    L154:
        r100.setSessionWithDomainMap(r104);
        goto L7
    L100:
        r104 = new LinkedHashMap();
        r110.beginObject();
    L102:
        if (r110.hasNext() == false) goto L153;
        String r105 = r110.nextName();
        if (r110.peek() != JsonToken.NULL) goto L106;
        r110.nextNull();
        SessionInfo r106 = null;
    L142:
        if (r106 == null) goto L102;
        String r107 = r106.getHostUrl();
        if (r107 != null) goto L146;
    L149:
        boolean r108 = true;
    L150:
        if (r108 == false) goto L152;
        r106.setHostUrl(r105);
    L152:
        r104.put(r105, r106);
        goto L102
    L146:
        if (StringsKt.isBlank(r107) == true) goto L149;
        r108 = false;
        goto L150
    L106:
        r106 = new SessionInfo();
        r110.beginObject();
    L108:
        if (r110.hasNext() == false) goto L141;
        String r109 = r110.nextName();
        if (r110.peek() == JsonToken.NULL) goto L111;
        if (r109 == null) goto L140;
        switch(r109.hashCode()) {
            case -686432620: goto L137;
            case -300231080: goto L133;
            case -22661567: goto L130;
            case 3373707: goto L127;
            case 111972721: goto L123;
            case 1098684071: goto L120;
            case 1984987798: goto L117;
            default: goto L140;
        };
    L120:
        if (r109.equals("hostUrl") == false) goto L140;
    L135:
        r106.setHostUrl(r110.nextString());
        goto L108
    L127:
        if (r109.equals("name") == false) goto L140;
    L139:
        r106.setSessionName(r110.nextString());
        goto L108
    L130:
        if (r109.equals(InteractConst.WAKEUP_SESSION_NAME) == true) goto L139;
    L133:
        if (r109.equals("host_url") == true) goto L135;
    L137:
        if (r109.equals("session_name") == true) goto L139;
    L117:
        if (r109.equals(AppbrandHostConstants.SCHEMA_INSPECT.SESSION) == false) goto L140;
    L125:
        r106.setSession(r110.nextString());
        goto L108
    L123:
        if (r109.equals("value") == true) goto L125;
    L140:
        r110.skipValue();
        goto L108
    L111:
        r110.nextNull();
        goto L108
    L141:
        r110.endObject();
        goto L142
    L153:
        r110.endObject();
        goto L154
    L33:
        if (r101.equals(CommonConstant.KEY_DISPLAY_NAME) == false) goto L251;
        r100.displayName = r110.nextString();
        goto L7
    L37:
        if (r101.equals("createTime") == false) goto L251;
        r100.createTime = r110.nextLong();
        goto L7
    L41:
        if (r101.equals("sl_session") == false) goto L251;
    L46:
        r100.setSlSession(r110.nextString());
        goto L7
    L44:
        if (r101.equals("slSession") == true) goto L46;
    L48:
        if (r101.equals("loginCredentialId") == false) goto L251;
        r100.setLoginCredentialId(r110.nextString());
        goto L7
    L52:
        if (r101.equals(com.bytedance.android.ec.core.event.a.KEY_IS_ANONYMOUS) == false) goto L251;
    L250:
        r100.setAnonymous(r110.nextBoolean());
        goto L7
    L55:
        if (r101.equals("current_env") == false) goto L251;
    L238:
        r100.setCurrentEnv(r110.nextString());
        goto L7
    L58:
        if (r101.equals("i18Name") == false) goto L251;
        r100.i18Name = a(r110);
        goto L7
    L62:
        if (r101.equals("name") == false) goto L251;
        r100.name = r110.nextString();
        goto L7
    L66:
        if (r101.equals("sessionUuid") == false) goto L251;
    L90:
        r100.setSessionUuid(r110.nextString());
        goto L7
    L69:
        if (r101.equals("userGeo") == false) goto L251;
        r100.userGeo = r110.nextString();
        goto L7
    L73:
        if (r101.equals("userUnit") == false) goto L251;
        String r111 = r110.nextString();
        PassportLog.d("UserListService", "read eu_nc6 2 eu_nc");
        if (Intrinsics.areEqual(r111, "eu_nc6") == false) goto L78;
        r111 = "eu_nc";
    L78:
        r100.userUnit = r111;
        goto L7
    L80:
        if (r101.equals("avatarUrl") == false) goto L251;
        r100.avatarUrl = r110.nextString();
        goto L7
    L84:
        if (r101.equals("avatarKey") == false) goto L251;
        r100.avatarKey = r110.nextString();
        goto L7
    L88:
        if (r101.equals("session_uuid") == true) goto L90;
    L92:
        if (r101.equals("deviceLoginId") == false) goto L251;
    L234:
        r100.setDeviceLoginId(r110.nextString());
        goto L7
    L95:
        if (r101.equals("sessionWithDomainMap") == true) goto L98;
    L156:
        if (r101.equals("userId") == false) goto L251;
        r100.userId = r110.nextString();
        goto L7
    L160:
        if (r101.equals("tenant") == false) goto L251;
        if (r110.peek() != r103) goto L165;
        r110.nextNull();
        Tenant r112 = null;
    L219:
        r100.tenant = r112;
        goto L7
    L165:
        r112 = new Tenant();
        r110.beginObject();
    L167:
        if (r110.hasNext() == false) goto L218;
        String r113 = r110.nextName();
        if (r113 == null) goto L217;
        switch(r113.hashCode()) {
            case -2141485979: goto L214;
            case -1852803513: goto L210;
            case -1306693787: goto L206;
            case -734439093: goto L202;
            case -366484489: goto L198;
            case 114586: goto L194;
            case 3373707: goto L190;
            case 155571963: goto L186;
            case 1638765110: goto L182;
            case 1863011581: goto L178;
            case 1973617166: goto L174;
            default: goto L217;
        };
    L178:
        if (r113.equals("tenantBrand") == false) goto L217;
        r112.setTenantBrand(r110.nextString());
        goto L167
    L182:
        if (r113.equals("iconUrl") == false) goto L217;
        r112.iconUrl = r110.nextString();
        goto L167
    L186:
        if (r113.equals("i18Name") == false) goto L217;
        r112.i18Name = a(r110);
        goto L167
    L190:
        if (r113.equals("name") == false) goto L217;
        r112.name = r110.nextString();
        goto L167
    L194:
        if (r113.equals("tag") == false) goto L217;
        r112.tag = r110.nextInt();
        goto L167
    L198:
        if (r113.equals("isCertificated") == false) goto L217;
        r112.isCertificated = r110.nextBoolean();
        goto L167
    L202:
        if (r113.equals("suiteFullDomain") == false) goto L217;
        r112.suiteFullDomain = r110.nextString();
        goto L167
    L206:
        if (r113.equals("tenantId") == false) goto L217;
        r112.tenantId = r110.nextString();
        goto L167
    L210:
        if (r113.equals("tenantGeo") == false) goto L217;
        r112.setTenantGeo(r110.nextString());
        goto L167
    L214:
        if (r113.equals("fromSource") == false) goto L217;
        r112.fromSource = r110.nextInt();
        goto L167
    L174:
        if (r113.equals("tenantDomain") == false) goto L217;
        r112.tenantDomain = r110.nextString();
    L217:
        r110.skipValue();
        goto L167
    L218:
        r110.endObject();
        goto L219
    L221:
        if (r101.equals("status") == false) goto L251;
        r100.setStatus(r110.nextInt());
        goto L7
    L225:
        if (r101.equals("isAnonymous") == true) goto L250;
    L228:
        if (r101.equals("i18DisplayName") == false) goto L251;
        r100.i18DisplayName = a(r110);
        goto L7
    L232:
        if (r101.equals("device_login_id") == true) goto L234;
    L236:
        if (r101.equals("currentEnv") == true) goto L238;
    L240:
        if (r101.equals("excludeLogin") == false) goto L251;
        r100.setExcludeLogin(r110.nextBoolean());
        goto L7
    L244:
        if (r101.equals("isTenantCreator") == false) goto L251;
        r100.isTenantCreator = r110.nextBoolean();
        goto L7
    L248:
        if (r101.equals("anonymous") == true) goto L250;
    L16:
        if (r101.equals("logout_token") == false) goto L251;
    L31:
        r100.setLogoutToken(r110.nextString());
        goto L7
    L29:
        if (r101.equals("logoutToken") == true) goto L31;
    L251:
        r110.skipValue();
        goto L7
    L10:
        r110.nextNull();
        goto L7
    L252:
        r110.endObject();
        return r100;
    }

    public static void b(JsonWriter r100, I18Name r101) {
        if (r101 != null) goto L5;
        r100.nullValue();
        return;
    L5:
        r100.beginObject();
        r100.name("zhCn").value(r101.zhCn);
        r100.name("enUs").value(r101.enUs);
        r100.name("jaJp").value(r101.jaJp);
        r100.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter r100, User r101) {
        User r102 = r101;
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        if (r102 != null) goto L5;
        r100.nullValue();
        return;
    L5:
        r100.beginObject();
        r100.name("userId").value(r102.userId);
        r100.name("name").value(r102.name);
        if (r102.i18Name == null) goto L8;
        r100.name("i18Name");
        b(r100, r102.i18Name);
    L8:
        r100.name(CommonConstant.KEY_DISPLAY_NAME).value(r102.displayName);
        if (r102.i18DisplayName == null) goto L11;
        r100.name("i18DisplayName");
        b(r100, r102.i18DisplayName);
    L11:
        r100.name("avatarUrl").value(r102.avatarUrl);
        r100.name("status").value(Integer.valueOf(r102.getStatus()));
        if (r102.tenant == null) goto L20;
        r100.name("tenant");
        Tenant r103 = r102.tenant;
        if (r103 != null) goto L16;
        r100.nullValue();
        goto L20
    L16:
        r100.beginObject();
        r100.name("tenantId").value(r103.tenantId);
        r100.name("name").value(r103.name);
        if (r103.i18Name == null) goto L19;
        r100.name("i18Name");
        b(r100, r103.i18Name);
    L19:
        r100.name("iconUrl").value(r103.iconUrl);
        r100.name("tag").value(Integer.valueOf(r103.tag));
        r100.name("tenantDomain").value(r103.tenantDomain);
        r100.name("suiteFullDomain").value(r103.suiteFullDomain);
        r100.name("tenantBrand").value(r103.getTenantBrand());
        r100.name("isCertificated").value(r103.isCertificated);
        r100.name("tenantGeo").value(r103.getTenantGeo());
        r100.name("fromSource").value(Integer.valueOf(r103.fromSource));
        r100.endObject();
    L20:
        r100.name("avatarKey").value(r102.avatarKey);
        r100.name("createTime").value(r102.createTime);
        r100.name("loginCredentialId").value(r102.getLoginCredentialId());
        r100.name(AppbrandHostConstants.SCHEMA_INSPECT.SESSION).value(r102.getSession());
        r100.name("slSession").value(r102.getSlSession());
        r100.name("sessionUuid").value(r102.getSessionUuid());
        r100.name("currentEnv").value(r102.getCurrentEnv());
        r100.name("logoutToken").value(r102.getLogoutToken());
        r100.name("deviceLoginId").value(r102.getDeviceLoginId());
        r100.name("anonymous").value(r102.isAnonymous());
        Map<String, SessionInfo> r104 = r102.getSessionWithDomainMap();
        if (r104 != null) goto L23;
    L26:
        boolean r105 = true;
    L27:
        if (r105 == true) goto L39;
        r100.name("sessionWithDomainMap");
        Map<String, SessionInfo> r106 = r102.getSessionWithDomainMap();
        if (r106 != null) goto L31;
        r100.nullValue();
        goto L39
    L31:
        r100.beginObject();
        Iterator<Map.Entry<String, SessionInfo>> r107 = r106.entrySet().iterator();
    L33:
        if (r107.hasNext() == false) goto L38;
        Map.Entry<String, SessionInfo> r108 = r107.next();
        String r109 = r108.getKey();
        SessionInfo r110 = r108.getValue();
        r100.name(r109);
        if (r110 == null) goto L36;
        r100.beginObject();
        r100.name("hostUrl").value(r110.getHostUrl());
        r100.name(InteractConst.WAKEUP_SESSION_NAME).value(r110.getSessionName());
        r100.name(AppbrandHostConstants.SCHEMA_INSPECT.SESSION).value(r110.getSession());
        r100.endObject();
        goto L33
    L36:
        r100.nullValue();
        goto L33
    L38:
        r100.endObject();
    L39:
        r100.name("userUnit").value(r102.userUnit);
        r100.name("userGeo").value(r102.userGeo);
        r100.name("excludeLogin").value(r102.isExcludeLogin());
        r100.name("isTenantCreator").value(r102.isTenantCreator);
        r100.endObject();
        return;
    L23:
        if (r104.isEmpty() == true) goto L26;
        r105 = false;
        goto L27
    }
}
