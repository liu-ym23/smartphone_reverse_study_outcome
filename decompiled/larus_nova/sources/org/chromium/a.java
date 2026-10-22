package org.chromium;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider;
import com.bytedance.frameworks.baselib.network.http.util.l;
import com.bytedance.ttnet.TTNetInit;
import com.ttnet.org.chromium.net.TTAppInfoProvider;
import java.net.CookieHandler;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class a extends TTAppInfoProvider {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static a f525630b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TTAppInfoProvider.AppInfo f525631a;

    @Override // com.ttnet.org.chromium.net.TTAppInfoProvider
    public final TTAppInfoProvider.AppInfo getAppInfo() {
        monitor-enter(a.class);     // Catch: Throwable -> L285
    L282:
        th = move-exception;
        throw th;     // Catch: Throwable -> L285
    L5:
        if (this.f525631a != null) goto L7;
        this.f525631a = new TTAppInfoProvider.AppInfo();     // Catch: Throwable -> L282
    L7:
        monitor-exit(a.class);     // Catch: Throwable -> L282
        TTAppInfoProvider.AppInfo r100 = this.f525631a;     // Catch: Throwable -> L285
        c r101 = c.h();     // Catch: Throwable -> L285
        r101.getClass();     // Catch: Throwable -> L285
        if (NetworkParams.getOptReflection() == false) goto L14;
        ICronetAppProvider r102 = r101.f525635b;     // Catch: Throwable -> L285
        if (r102 != null) goto L13;
        String r103 = "";
    L15:
        r100.setAppId(r103);     // Catch: Throwable -> L285
        TTAppInfoProvider.AppInfo r104 = this.f525631a;     // Catch: Throwable -> L285
        c r105 = c.h();     // Catch: Throwable -> L285
        r105.getClass();     // Catch: Throwable -> L285
        if (NetworkParams.getOptReflection() == false) goto L21;
        ICronetAppProvider r106 = r105.f525635b;     // Catch: Throwable -> L285
        if (r106 != null) goto L20;
        String r107 = "";
    L22:
        r104.setAppName(r107);     // Catch: Throwable -> L285
        TTAppInfoProvider.AppInfo r108 = this.f525631a;     // Catch: Throwable -> L285
        c r109 = c.h();     // Catch: Throwable -> L285
        r109.getClass();     // Catch: Throwable -> L285
        if (NetworkParams.getOptReflection() == false) goto L28;
        ICronetAppProvider r110 = r109.f525635b;     // Catch: Throwable -> L285
        if (r110 != null) goto L27;
        String r111 = "";
    L29:
        r108.setSdkAppID(r111);     // Catch: Throwable -> L285
        TTAppInfoProvider.AppInfo r112 = this.f525631a;     // Catch: Throwable -> L285
        c r113 = c.h();     // Catch: Throwable -> L285
        r113.getClass();     // Catch: Throwable -> L285
        if (NetworkParams.getOptReflection() == false) goto L35;
        ICronetAppProvider r114 = r113.f525635b;     // Catch: Throwable -> L285
        if (r114 != null) goto L34;
        String r115 = "";
    L36:
        r112.setSdkVersion(r115);     // Catch: Throwable -> L285
        TTAppInfoProvider.AppInfo r116 = this.f525631a;     // Catch: Throwable -> L285
        c r117 = c.h();     // Catch: Throwable -> L285
        r117.getClass();     // Catch: Throwable -> L285
        if (NetworkParams.getOptReflection() == false) goto L42;
        ICronetAppProvider r118 = r117.f525635b;     // Catch: Throwable -> L285
        if (r118 != null) goto L41;
        String r119 = "";
    L43:
        r116.setChannel(r119);     // Catch: Throwable -> L285
        TTAppInfoProvider.AppInfo r120 = this.f525631a;     // Catch: Throwable -> L285
        c r121 = c.h();     // Catch: Throwable -> L285
        r121.getClass();     // Catch: Throwable -> L285
        if (NetworkParams.getOptReflection() == false) goto L49;
        ICronetAppProvider r122 = r121.f525635b;     // Catch: Throwable -> L285
        if (r122 != null) goto L48;
        String r123 = "";
    L50:
        r120.setDeviceId(r123);     // Catch: Throwable -> L285
        TTAppInfoProvider.AppInfo r124 = this.f525631a;     // Catch: Throwable -> L285
        c r125 = c.h();     // Catch: Throwable -> L285
        r125.getClass();     // Catch: Throwable -> L285
    L62:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L285
        String r126 = "";
    L64:
        r124.setIsDropFirstTnc(r126);     // Catch: Throwable -> L285
        TTAppInfoProvider.AppInfo r127 = this.f525631a;     // Catch: Throwable -> L285
        c r128 = c.h();     // Catch: Throwable -> L285
        r128.getClass();     // Catch: Throwable -> L285
        if (NetworkParams.getOptReflection() == false) goto L70;
        ICronetAppProvider r129 = r128.f525635b;     // Catch: Throwable -> L285
        if (r129 != null) goto L69;
        String r130 = "";
    L71:
        r127.setAbi(r130);     // Catch: Throwable -> L285
        TTAppInfoProvider.AppInfo r131 = this.f525631a;     // Catch: Throwable -> L285
        c r132 = c.h();     // Catch: Throwable -> L285
        r132.getClass();     // Catch: Throwable -> L285
        if (NetworkParams.getOptReflection() == false) goto L77;
        ICronetAppProvider r133 = r132.f525635b;     // Catch: Throwable -> L285
        if (r133 != null) goto L76;
        String r134 = "";
    L78:
        r131.setDevicePlatform(r134);     // Catch: Throwable -> L285
        TTAppInfoProvider.AppInfo r135 = this.f525631a;     // Catch: Throwable -> L285
        c r136 = c.h();     // Catch: Throwable -> L285
        r136.getClass();     // Catch: Throwable -> L285
        if (NetworkParams.getOptReflection() == false) goto L84;
        ICronetAppProvider r137 = r136.f525635b;     // Catch: Throwable -> L285
        if (r137 != null) goto L83;
        String r138 = "";
    L85:
        r135.setDeviceType(r138);     // Catch: Throwable -> L285
        TTAppInfoProvider.AppInfo r139 = this.f525631a;     // Catch: Throwable -> L285
        c r140 = c.h();     // Catch: Throwable -> L285
        r140.getClass();     // Catch: Throwable -> L285
        if (NetworkParams.getOptReflection() == false) goto L91;
        ICronetAppProvider r141 = r140.f525635b;     // Catch: Throwable -> L285
        if (r141 != null) goto L90;
        String r142 = "";
    L92:
        r139.setDeviceBrand(r142);     // Catch: Throwable -> L285
        TTAppInfoProvider.AppInfo r143 = this.f525631a;     // Catch: Throwable -> L285
        c r144 = c.h();     // Catch: Throwable -> L285
        r144.getClass();     // Catch: Throwable -> L285
        if (NetworkParams.getOptReflection() == false) goto L98;
        ICronetAppProvider r145 = r144.f525635b;     // Catch: Throwable -> L285
        if (r145 != null) goto L97;
        String r146 = "";
    L99:
        r143.setDeviceModel(r146);     // Catch: Throwable -> L285
        TTAppInfoProvider.AppInfo r147 = this.f525631a;     // Catch: Throwable -> L285
        c r148 = c.h();     // Catch: Throwable -> L285
        r148.getClass();     // Catch: Throwable -> L285
        if (NetworkParams.getOptReflection() == false) goto L105;
        ICronetAppProvider r149 = r148.f525635b;     // Catch: Throwable -> L285
        if (r149 != null) goto L104;
        String r150 = "";
    L106:
        r147.setNetAccessType(r150);     // Catch: Throwable -> L285
        TTAppInfoProvider.AppInfo r151 = this.f525631a;     // Catch: Throwable -> L285
        c r152 = c.h();     // Catch: Throwable -> L285
        r152.getClass();     // Catch: Throwable -> L285
        if (NetworkParams.getOptReflection() == false) goto L112;
        ICronetAppProvider r153 = r152.f525635b;     // Catch: Throwable -> L285
        if (r153 != null) goto L111;
        String r154 = "";
    L113:
        r151.setOSApi(r154);     // Catch: Throwable -> L285
        TTAppInfoProvider.AppInfo r155 = this.f525631a;     // Catch: Throwable -> L285
        c r156 = c.h();     // Catch: Throwable -> L285
        r156.getClass();     // Catch: Throwable -> L285
        if (NetworkParams.getOptReflection() == false) goto L119;
        ICronetAppProvider r157 = r156.f525635b;     // Catch: Throwable -> L285
        if (r157 != null) goto L118;
        String r158 = "";
    L120:
        r155.setOSVersion(r158);     // Catch: Throwable -> L285
        TTAppInfoProvider.AppInfo r159 = this.f525631a;     // Catch: Throwable -> L285
        c r160 = c.h();     // Catch: Throwable -> L285
        r160.getClass();     // Catch: Throwable -> L285
        if (NetworkParams.getOptReflection() == false) goto L126;
        ICronetAppProvider r161 = r160.f525635b;     // Catch: Throwable -> L285
        if (r161 != null) goto L125;
        String r162 = "";
    L127:
        r159.setUserId(r162);     // Catch: Throwable -> L285
        TTAppInfoProvider.AppInfo r163 = this.f525631a;     // Catch: Throwable -> L285
        c r164 = c.h();     // Catch: Throwable -> L285
        r164.getClass();     // Catch: Throwable -> L285
        if (NetworkParams.getOptReflection() == false) goto L133;
        ICronetAppProvider r165 = r164.f525635b;     // Catch: Throwable -> L285
        if (r165 != null) goto L132;
        String r166 = "";
    L134:
        r163.setVersionCode(r166);     // Catch: Throwable -> L285
        TTAppInfoProvider.AppInfo r167 = this.f525631a;     // Catch: Throwable -> L285
        c r168 = c.h();     // Catch: Throwable -> L285
        r168.getClass();     // Catch: Throwable -> L285
        if (NetworkParams.getOptReflection() == false) goto L140;
        ICronetAppProvider r169 = r168.f525635b;     // Catch: Throwable -> L285
        if (r169 != null) goto L139;
        String r170 = "";
    L141:
        r167.setVersionName(r170);     // Catch: Throwable -> L285
        TTAppInfoProvider.AppInfo r171 = this.f525631a;     // Catch: Throwable -> L285
        c r172 = c.h();     // Catch: Throwable -> L285
        r172.getClass();     // Catch: Throwable -> L285
        if (NetworkParams.getOptReflection() == false) goto L147;
        ICronetAppProvider r173 = r172.f525635b;     // Catch: Throwable -> L285
        if (r173 != null) goto L146;
        String r174 = "";
    L148:
        r171.setUpdateVersionCode(r174);     // Catch: Throwable -> L285
        TTAppInfoProvider.AppInfo r175 = this.f525631a;     // Catch: Throwable -> L285
        c r176 = c.h();     // Catch: Throwable -> L285
        r176.getClass();     // Catch: Throwable -> L285
        if (NetworkParams.getOptReflection() == false) goto L154;
        ICronetAppProvider r177 = r176.f525635b;     // Catch: Throwable -> L285
        if (r177 != null) goto L153;
        String r178 = "";
    L155:
        r175.setManifestVersionCode(r178);     // Catch: Throwable -> L285
        TTAppInfoProvider.AppInfo r179 = this.f525631a;     // Catch: Throwable -> L285
        c r180 = c.h();     // Catch: Throwable -> L285
        r180.getClass();     // Catch: Throwable -> L285
        if (NetworkParams.getOptReflection() == false) goto L161;
        ICronetAppProvider r181 = r180.f525635b;     // Catch: Throwable -> L285
        if (r181 != null) goto L160;
        String r182 = "";
    L162:
        r179.setStoreIdc(r182);     // Catch: Throwable -> L285
        TTAppInfoProvider.AppInfo r183 = this.f525631a;     // Catch: Throwable -> L285
        c r184 = c.h();     // Catch: Throwable -> L285
        r184.getClass();     // Catch: Throwable -> L285
        if (NetworkParams.getOptReflection() == false) goto L168;
        ICronetAppProvider r185 = r184.f525635b;     // Catch: Throwable -> L285
        if (r185 != null) goto L167;
        String r186 = "";
    L170:
        if (TextUtils.isEmpty(r186) == true) goto L173;
        r186 = r186.toLowerCase();     // Catch: Throwable -> L285
    L173:
        r183.setRegion(r186);     // Catch: Throwable -> L285
        TTAppInfoProvider.AppInfo r187 = this.f525631a;     // Catch: Throwable -> L285
        c r188 = c.h();     // Catch: Throwable -> L285
        r188.getClass();     // Catch: Throwable -> L285
        if (NetworkParams.getOptReflection() == false) goto L179;
        ICronetAppProvider r189 = r188.f525635b;     // Catch: Throwable -> L285
        if (r189 != null) goto L178;
        String r190 = "";
    L181:
        if (TextUtils.isEmpty(r190) == true) goto L184;
        r190 = r190.toLowerCase();     // Catch: Throwable -> L285
    L184:
        r187.setSysRegion(r190);     // Catch: Throwable -> L285
        TTAppInfoProvider.AppInfo r191 = this.f525631a;     // Catch: Throwable -> L285
        c r192 = c.h();     // Catch: Throwable -> L285
        r192.getClass();     // Catch: Throwable -> L285
        if (NetworkParams.getOptReflection() == false) goto L190;
        ICronetAppProvider r193 = r192.f525635b;     // Catch: Throwable -> L285
        if (r193 != null) goto L189;
        String r194 = "";
    L192:
        if (TextUtils.isEmpty(r194) == true) goto L195;
        r194 = r194.toLowerCase();     // Catch: Throwable -> L285
    L195:
        r191.setCarrierRegion(r194);     // Catch: Throwable -> L285
        TTAppInfoProvider.AppInfo r195 = this.f525631a;     // Catch: Throwable -> L285
        c r196 = c.h();     // Catch: Throwable -> L285
        r196.getClass();     // Catch: Throwable -> L285
        if (NetworkParams.getOptReflection() == false) goto L201;
        ICronetAppProvider r197 = r196.f525635b;     // Catch: Throwable -> L285
        if (r197 != null) goto L200;
        String r198 = "";
    L202:
        r195.setInitRegion(r198);     // Catch: Throwable -> L285
        TTAppInfoProvider.AppInfo r199 = this.f525631a;     // Catch: Throwable -> L285
        c r200 = c.h();     // Catch: Throwable -> L285
        r200.getClass();     // Catch: Throwable -> L285
        if (NetworkParams.getOptReflection() == false) goto L208;
        ICronetAppProvider r201 = r200.f525635b;     // Catch: Throwable -> L285
        if (r201 != null) goto L207;
        String r202 = "";
    L209:
        r199.setTNCRequestFlags(r202);     // Catch: Throwable -> L285
        TTAppInfoProvider.AppInfo r203 = this.f525631a;     // Catch: Throwable -> L285
        c r204 = c.h();     // Catch: Throwable -> L285
        r204.getClass();     // Catch: Throwable -> L285
        if (NetworkParams.getOptReflection() == false) goto L215;
        ICronetAppProvider r205 = r204.f525635b;     // Catch: Throwable -> L285
        if (r205 != null) goto L214;
        String r206 = "";
    L216:
        r203.setHttpDnsRequestFlags(r206);     // Catch: Throwable -> L285
        TTAppInfoProvider.AppInfo r207 = this.f525631a;     // Catch: Throwable -> L285
        if (sx5.b.f543816o == false) goto L219;
        String r208 = "1";
    L220:
        r207.setIsDomestic(r208);     // Catch: Throwable -> L285
        c r209 = c.h();     // Catch: Throwable -> L285
        r209.getClass();     // Catch: Throwable -> L285
    L232:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L285
        Map<String, String> r210 = Collections.emptyMap();     // Catch: Throwable -> L285
    L234:
        if (r210 != null) goto L236;
    L238:
        Map<String, String> r211 = c.h().f();     // Catch: Throwable -> L285
        String r212 = "";
        if (r211 != null) goto L241;
    L246:
        String r213 = "";
        if (r210 == null) goto L252;
        if (r210.isEmpty() == true) goto L252;
        r213 = a(r210.get(SoloKtvContext.SOLO_PAGE_FIRST));     // Catch: Throwable -> L285
    L252:
        if (TextUtils.isEmpty(r213) == true) goto L254;
        r212 = "Cookie:" + r213 + "\r\n" + r212;     // Catch: Throwable -> L285
    L254:
        this.f525631a.setTNCRequestHeader(r212);     // Catch: Throwable -> L285
        Map<String, String> r214 = c.h().g();     // Catch: Throwable -> L285
        String r215 = "";
        if (r214 != null) goto L257;
    L262:
        this.f525631a.setTNCRequestQuery(r215);     // Catch: Throwable -> L285
        List<String> r216 = c.h().a();     // Catch: Throwable -> L285
        String r217 = "";
        if (r216 != null) goto L265;
    L278:
        this.f525631a.setAbSdkVersion(r217);     // Catch: Throwable -> L285
        if (d.a().loggerDebug() == false) goto L288;
        String r218 = "AppInfo{, mUserId='" + this.f525631a.getUserId() + "', mAppId='" + this.f525631a.getAppId() + "', mOSApi='" + this.f525631a.getOSApi() + "', mDeviceId='" + this.f525631a.getDeviceId() + "', mNetAccessType='" + this.f525631a.getNetAccessType() + "', mVersionCode='" + this.f525631a.getVersionCode() + "', mDeviceType='" + this.f525631a.getDeviceType() + "', mAppName='" + this.f525631a.getAppName() + "', mSdkAppID='" + this.f525631a.getSdkAppID() + "', mSdkVersion='" + this.f525631a.getSdkVersion() + "', mChannel='" + this.f525631a.getChannel() + "', mOSVersion='" + this.f525631a.getOSVersion() + "', mAbi='" + this.f525631a.getAbi() + "', mDevicePlatform='" + this.f525631a.getDevicePlatform() + "', mDeviceBrand='" + this.f525631a.getDeviceBrand() + "', mDeviceModel='" + this.f525631a.getDeviceModel() + "', mVersionName='" + this.f525631a.getVersionName() + "', mUpdateVersionCode='" + this.f525631a.getUpdateVersionCode() + "', mManifestVersionCode='" + this.f525631a.getManifestVersionCode() + "'}";     // Catch: Throwable -> L285
        d.a().loggerD("CronetAppInfoProvider", "get appinfo = " + r218);     // Catch: Throwable -> L285
    L288:
        return this.f525631a;
    L265:
        if (r216.size() > 5) goto L267;
    L269:
        Iterator<String> r219 = r216.iterator();     // Catch: Throwable -> L285
        int r220 = 0;
    L271:
        if (r219.hasNext() == false) goto L278;
        String r221 = r219.next();     // Catch: Throwable -> L285
        r220 = r220 + 1;     // Catch: Throwable -> L285
        if (r220 > 5) goto L278;
        if (TextUtils.isEmpty(r221) == true) goto L271;
        r217 = r217 + r221 + ",";     // Catch: Throwable -> L285
        goto L271
    L267:
        if (d.a().loggerDebug() == false) goto L269;
        d.a().loggerD("CronetAppInfoProvider", "ab sdk version count must less than 5");     // Catch: Throwable -> L285
        goto L269
    L257:
        if (r214.isEmpty() == true) goto L262;
        Iterator<Map.Entry<String, String>> r222 = r214.entrySet().iterator();     // Catch: Throwable -> L285
    L260:
        if (r222.hasNext() == false) goto L262;
        Map.Entry<String, String> r223 = r222.next();     // Catch: Throwable -> L285
        r215 = r223.getKey() + ":" + r223.getValue() + "\r\n" + r215;     // Catch: Throwable -> L285
        goto L260
    L241:
        if (r211.isEmpty() == true) goto L246;
        Iterator<Map.Entry<String, String>> r224 = r211.entrySet().iterator();     // Catch: Throwable -> L285
    L244:
        if (r224.hasNext() == false) goto L246;
        Map.Entry<String, String> r225 = r224.next();     // Catch: Throwable -> L285
        r212 = r225.getKey() + ":" + r225.getValue() + "\r\n" + r212;     // Catch: Throwable -> L285
        goto L244
    L236:
        if (r210.isEmpty() == true) goto L238;
        this.f525631a.setHostFirst(r210.get(SoloKtvContext.SOLO_PAGE_FIRST));     // Catch: Throwable -> L285
        this.f525631a.setHostSecond(r210.get("second"));     // Catch: Throwable -> L285
        this.f525631a.setHostThird(r210.get(com.alipay.sdk.m.k.b.f25414o));     // Catch: Throwable -> L285
        this.f525631a.setDomainHttpDns(r210.get("httpdns"));     // Catch: Throwable -> L285
        this.f525631a.setDomainBoe(r210.get("boe"));     // Catch: Throwable -> L285
        this.f525631a.setDomainBoeHttps(r210.get(TTNetInit.DOMAIN_BOE_HTTPS_KEY));     // Catch: Throwable -> L285
        goto L238
    L222:
        if (NetworkParams.getOptReflection() == false) goto L227;
        ICronetAppProvider r226 = r209.f525635b;     // Catch: Throwable -> L232
        if (r226 != null) goto L226;
        r210 = Collections.emptyMap();     // Catch: Throwable -> L232
    L289:
    L226:
        r210 = r226.getGetDomainDependHostMap();     // Catch: Throwable -> L232
        goto L289
    L227:
        Object r227 = r209.f525634a;     // Catch: Throwable -> L232
        if (r227 != null) goto L230;
        r210 = Collections.emptyMap();     // Catch: Throwable -> L232
        goto L289
    L230:
        r210 = (Map) yx5.a.b(r227).call("getGetDomainDependHostMap").get();     // Catch: Throwable -> L232
        goto L289
    L219:
        r208 = "0";
        goto L220
    L214:
        r206 = r205.getHttpDnsRequestFlags();     // Catch: Throwable -> L285
        goto L216
    L215:
        r206 = r204.e("getHttpDnsRequestFlags");     // Catch: Throwable -> L285
        goto L216
    L207:
        r202 = r201.getTNCRequestFlags();     // Catch: Throwable -> L285
        goto L209
    L208:
        r202 = r200.e("getTNCRequestFlags");     // Catch: Throwable -> L285
        goto L209
    L200:
        r198 = r197.getAppInitialRegionInfo();     // Catch: Throwable -> L285
        goto L202
    L201:
        r198 = r196.e("getAppInitialRegionInfo");     // Catch: Throwable -> L285
        goto L202
    L189:
        r194 = r193.getCarrierRegion();     // Catch: Throwable -> L285
        goto L192
    L190:
        r194 = r192.e("getCarrierRegion");     // Catch: Throwable -> L285
        goto L192
    L178:
        r190 = r189.getSysRegion();     // Catch: Throwable -> L285
        goto L181
    L179:
        r190 = r188.e("getSysRegion");     // Catch: Throwable -> L285
        goto L181
    L167:
        r186 = r185.getRegion();     // Catch: Throwable -> L285
        goto L170
    L168:
        r186 = r184.e("getRegion");     // Catch: Throwable -> L285
        goto L170
    L160:
        r182 = r181.getStoreIdc();     // Catch: Throwable -> L285
        goto L162
    L161:
        r182 = r180.e("getStoreIdc");     // Catch: Throwable -> L285
        goto L162
    L153:
        r178 = r177.getManifestVersionCode();     // Catch: Throwable -> L285
        goto L155
    L154:
        r178 = r176.e("getManifestVersionCode");     // Catch: Throwable -> L285
        goto L155
    L146:
        r174 = r173.getUpdateVersionCode();     // Catch: Throwable -> L285
        goto L148
    L147:
        r174 = r172.e("getUpdateVersionCode");     // Catch: Throwable -> L285
        goto L148
    L139:
        r170 = r169.getVersionName();     // Catch: Throwable -> L285
        goto L141
    L140:
        r170 = r168.e("getVersionName");     // Catch: Throwable -> L285
        goto L141
    L132:
        r166 = r165.getVersionCode();     // Catch: Throwable -> L285
        goto L134
    L133:
        r166 = r164.e("getVersionCode");     // Catch: Throwable -> L285
        goto L134
    L125:
        r162 = r161.getUserId();     // Catch: Throwable -> L285
        goto L127
    L126:
        r162 = r160.e("getUserId");     // Catch: Throwable -> L285
        goto L127
    L118:
        r158 = r157.getOSVersion();     // Catch: Throwable -> L285
        goto L120
    L119:
        r158 = r156.e("getOSVersion");     // Catch: Throwable -> L285
        goto L120
    L111:
        r154 = r153.getOSApi();     // Catch: Throwable -> L285
        goto L113
    L112:
        r154 = r152.e("getOSApi");     // Catch: Throwable -> L285
        goto L113
    L104:
        r150 = r149.getNetAccessType();     // Catch: Throwable -> L285
        goto L106
    L105:
        r150 = r148.e("getNetAccessType");     // Catch: Throwable -> L285
        goto L106
    L97:
        r146 = r145.getDeviceModel();     // Catch: Throwable -> L285
        goto L99
    L98:
        r146 = r144.e("getDeviceModel");     // Catch: Throwable -> L285
        goto L99
    L90:
        r142 = r141.getDeviceBrand();     // Catch: Throwable -> L285
        goto L92
    L91:
        r142 = r140.e("getDeviceBrand");     // Catch: Throwable -> L285
        goto L92
    L83:
        r138 = r137.getDeviceType();     // Catch: Throwable -> L285
        goto L85
    L84:
        r138 = r136.e("getDeviceType");     // Catch: Throwable -> L285
        goto L85
    L76:
        r134 = r133.getDevicePlatform();     // Catch: Throwable -> L285
        goto L78
    L77:
        r134 = r132.e("getDevicePlatform");     // Catch: Throwable -> L285
        goto L78
    L69:
        r130 = r129.getAbi();     // Catch: Throwable -> L285
        goto L71
    L70:
        r130 = r128.e("getAbi");     // Catch: Throwable -> L285
        goto L71
    L52:
        if (NetworkParams.getOptReflection() == false) goto L57;
        ICronetAppProvider r228 = r125.f525635b;     // Catch: Throwable -> L62
        if (r228 == null) goto L59;
        r126 = r228.getIsDropFirstTnc();     // Catch: Throwable -> L62
    L294:
    L59:
        r126 = null;
        goto L294
    L57:
        Object r229 = r125.f525634a;     // Catch: Throwable -> L62
        if (r229 == null) goto L59;
        r126 = (String) yx5.a.b(r229).call("getIsDropFirstTnc").get();     // Catch: Throwable -> L62
        goto L294
    L48:
        r123 = r122.getDeviceId();     // Catch: Throwable -> L285
        goto L50
    L49:
        r123 = r121.e("getDeviceId");     // Catch: Throwable -> L285
        goto L50
    L41:
        r119 = r118.getChannel();     // Catch: Throwable -> L285
        goto L43
    L42:
        r119 = r117.e("getChannel");     // Catch: Throwable -> L285
        goto L43
    L34:
        r115 = r114.getSdkVersion();     // Catch: Throwable -> L285
        goto L36
    L35:
        r115 = r113.e("getSdkVersion");     // Catch: Throwable -> L285
        goto L36
    L27:
        r111 = r110.getSdkAppId();     // Catch: Throwable -> L285
        goto L29
    L28:
        r111 = r109.e("getSdkAppId");     // Catch: Throwable -> L285
        goto L29
    L20:
        r107 = r106.getAppName();     // Catch: Throwable -> L285
        goto L22
    L21:
        r107 = r105.e("getAppName");     // Catch: Throwable -> L285
        goto L22
    L13:
        r103 = r102.getAppId();     // Catch: Throwable -> L285
        goto L15
    L14:
        r103 = r101.e("getAppId");     // Catch: Throwable -> L285
        goto L15
    L285:
        th = move-exception;
        th.printStackTrace();
        goto L288
    }

    public a(Context r100) {
        r100.getApplicationContext();
    }

    public static String a(String r100) {
        CookieHandler r101 = CookieHandler.getDefault();
        if (TextUtils.isEmpty(r100) == true) goto L26;
        if (r101 == null) goto L26;
        Map<String, List<String>> r102 = r101.get(l.a("https://" + r100), null);     // Catch: Throwable -> L27
        if (r102 == null) goto L26;
        if (r102.size() <= 0) goto L26;
        Iterator<Map.Entry<String, List<String>>> r103 = r102.entrySet().iterator();     // Catch: Throwable -> L27
    L12:
        if (r103.hasNext() == false) goto L26;
        Map.Entry<String, List<String>> r104 = r103.next();     // Catch: Throwable -> L27
        if ("Cookie".equalsIgnoreCase(r104.getKey()) == false) goto L12;
        if (r104.getValue().isEmpty() == true) goto L12;
        StringBuilder r105 = new StringBuilder();     // Catch: Throwable -> L27
        Iterator<String> r106 = r104.getValue().iterator();     // Catch: Throwable -> L27
        int r107 = 0;
    L19:
        if (r106.hasNext() == false) goto L24;
        String r108 = r106.next();     // Catch: Throwable -> L27
        if (r107 <= 0) goto L23;
        r105.append("; ");     // Catch: Throwable -> L27
    L23:
        r105.append(r108);     // Catch: Throwable -> L27
        r107 = r107 + 1;     // Catch: Throwable -> L27
        goto L19
    L24:
        return r105.toString();
    L26:
        return null;
    }

    public static a b(Context r100) {
        if (f525630b != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f525630b != null) goto L9;
        f525630b = new a(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f525630b;
    }
}
