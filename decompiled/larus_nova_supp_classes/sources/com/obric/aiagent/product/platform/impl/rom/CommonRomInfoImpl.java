package com.obric.aiagent.product.platform.impl.rom;

import android.os.Build;
import android.util.EventsUtils;
import com.bytedance.mira.log.MiraMonitor;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.product.platform.api.rom.IRomInfo;
import iaa.b;
import iaa.d;
import iaa.e;
import iaa.j;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.TextStyle;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\u000e\u001a\u00020\u00052\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u0010H\u0016J\b\u0010\u0011\u001a\u00020\fH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0007H\u0016J\b\u0010\u0015\u001a\u00020\u0007H\u0016J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0013H\u0016¨\u0006\u001b"}, d2 = {"Lcom/obric/aiagent/product/platform/impl/rom/CommonRomInfoImpl;", "Lcom/obric/aiagent/product/platform/api/rom/IRomInfo;", "<init>", "()V", "tryInit", XmlPullParser.NO_NAMESPACE, "getDeviceBrand", XmlPullParser.NO_NAMESPACE, "getDeviceModel", "getOSVersion", "getShortOSVersion", "getOSReleaseDate", XmlPullParser.NO_NAMESPACE, "getOSDeviceIdFromCache", "getOSDeviceIdAsync", "callback", "Lkotlin/Function1;", "getFwkApiVersion", "useAssistantApi", XmlPullParser.NO_NAMESPACE, "getRomReleaseRegion", "getRomBuildType", "isOautoModelPreinstalled", "context", "Landroid/content/Context;", "isUTRom", "Companion", "product-platform_release"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class CommonRomInfoImpl implements IRomInfo {

    public static final class a {
    }

    static {
    }

    public CommonRomInfoImpl() {
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public final String a() {
        return null;
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public final boolean e() {
        return false;
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public final void i() {
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public final String b() {
        String r0 = Build.VERSION.INCREMENTAL;
        Regex r1 = d.a;
        Intrinsics.checkNotNull(r0);
        String r2 = d.b(r0);
        ILogDepend.a.i("CommonRomInfoImpl", "getShortOSVersion: incrementalVersion " + r0 + ", shortVersion " + r2);
        return r2;
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public final boolean d() {
        b.a.getClass();
        return b.d();
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public final String f() {
        return e.b("ro.vendor.feature.zte_feature_abroad", "MAINLAND");
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public final String g() {
        String r0 = e.b("ro.build.type", "unknown");
        if (Intrinsics.areEqual(e.b("ro.debuggable", MiraMonitor.VALUE_DEFAULT), "1") == false) goto L5;
        String r1 = "root";
    L6:
        ILogDepend.a.i("CommonRomInfoImpl", "getRomBuildType: buildType " + r0 + ", isRoot " + r1);
        return r0 + r1;
    L5:
        r1 = XmlPullParser.NO_NAMESPACE;
        goto L6
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public final int h() {
        b.a.getClass();
        return b.a();
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public final int c() {
        CastLongProtector.parseLong(e.b("ro.build.date.utc", MiraMonitor.VALUE_DEFAULT));
        int r1 = j.a;
        long r3 = Build.TIME;
    L9:
        int r4 = 0;
    L10:
        int r5 = j.a;
        String r2 = e.b("ro.build.date", MiraMonitor.VALUE_DEFAULT);
        Intrinsics.checkNotNullParameter(r2, "data");
        String r6 = StringsKt.trim(r2).toString();
        Integer r7 = null;
        if (StringsKt.isBlank(r6) == false) goto L81;
        System.out.println("ro.build.date 属性为空");
    L77:
        ILogDepend.a.i("CommonRomInfoImpl", "getOSReleaseDate: time " + Build.TIME + ", date " + r4 + ", data2 " + r7 + ' ');
        if (r7 != null) goto L80;
        return r4;
    L80:
        return r7.intValue();
    L81:
        String r0 = ZonedDateTime.parse(r6, new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern("EEE MMM dd HH:mm:ss ").appendZoneText(TextStyle.SHORT).appendPattern(" yyyy").toFormatter(Locale.ENGLISH)).format(DateTimeFormatter.ofPattern("yyyyMMdd"));     // Catch: Exception -> L16
        Intrinsics.checkNotNull(r0);     // Catch: Exception -> L16
        r7 = Integer.valueOf(CastIntegerProtector.parseInt(r0));     // Catch: Exception -> L16
    L16:
        e = move-exception;
        System.out.println("解析 ro.build.date 失败：" + e.getMessage() + "，尝试降级解析");
        MatchResult r8 = Regex.find$default(new Regex("(\\d{4})\\D*(\\d{2}|\\w{3})\\D*(\\d{2})"), r6, 0, 2, null);
        if (r8 == null) goto L77;
        MatchResult.Destructured r9 = r8.getDestructured();
        String r10 = (String) ListProtector.get(r9.getMatch().getGroupValues(), 1);
        String r11 = (String) ListProtector.get(r9.getMatch().getGroupValues(), 2);
        String r12 = (String) ListProtector.get(r9.getMatch().getGroupValues(), 3);
        if (new Regex("\\d{2}").matches(r11) == false) goto L23;
        Integer r13 = Integer.valueOf(CastIntegerProtector.parseInt(r11));
    L75:
        if (r13 == null) goto L77;
        int r14 = r13.intValue();
        StringCompanionObject r15 = StringCompanionObject.INSTANCE;
        r7 = Integer.valueOf(CastIntegerProtector.parseInt(String.format("%04d%02d%02d", Arrays.copyOf(new Object[]{Integer.valueOf(CastIntegerProtector.parseInt(r10)), Integer.valueOf(r14), Integer.valueOf(CastIntegerProtector.parseInt(r12))}, 3))));
        goto L77
    L23:
        String r16 = r11.toUpperCase(Locale.ENGLISH);
        switch(r16.hashCode()) {
            case 65027: goto L71;
            case 65171: goto L67;
            case 67554: goto L63;
            case 69475: goto L59;
            case 73207: goto L55;
            case 73825: goto L51;
            case 73827: goto L47;
            case 76094: goto L43;
            case 76101: goto L39;
            case 77493: goto L35;
            case 78080: goto L31;
            case 81982: goto L27;
            default: goto L74;
        };
    L74:
        r13 = null;
        goto L75
    L27:
        if (r16.equals("SEP") == false) goto L86;
        r13 = 9;
        goto L75
    L86:
        r13 = null;
        goto L75
    L31:
        if (r16.equals("OCT") == false) goto L87;
        r13 = 10;
        goto L75
    L87:
        r13 = null;
        goto L75
    L35:
        if (r16.equals("NOV") == false) goto L88;
        r13 = 11;
        goto L75
    L88:
        r13 = null;
        goto L75
    L39:
        if (r16.equals("MAY") == false) goto L89;
        r13 = 5;
        goto L75
    L89:
        r13 = null;
        goto L75
    L43:
        if (r16.equals("MAR") == false) goto L90;
        r13 = 3;
        goto L75
    L90:
        r13 = null;
        goto L75
    L47:
        if (r16.equals("JUN") == false) goto L91;
        r13 = 6;
        goto L75
    L91:
        r13 = null;
        goto L75
    L51:
        if (r16.equals("JUL") == false) goto L92;
        r13 = 7;
        goto L75
    L92:
        r13 = null;
        goto L75
    L55:
        if (r16.equals("JAN") == false) goto L93;
        r13 = 1;
        goto L75
    L93:
        r13 = null;
        goto L75
    L59:
        if (r16.equals("FEB") == false) goto L94;
        r13 = 2;
        goto L75
    L94:
        r13 = null;
        goto L75
    L63:
        if (r16.equals("DEC") == false) goto L95;
        r13 = 12;
        goto L75
    L95:
        r13 = null;
        goto L75
    L67:
        if (r16.equals("AUG") == false) goto L96;
        r13 = 8;
        goto L75
    L96:
        r13 = null;
        goto L75
    L71:
        if (r16.equals("APR") == false) goto L97;
        r13 = 4;
        goto L75
    L97:
        r13 = null;
        goto L75
    L5:
        if (Build.VERSION.SDK_INT < 26) goto L7;
        String r17 = DateTimeFormatter.ofPattern("yyyyMMdd").withZone(ZoneId.of("Asia/Shanghai")).format(Instant.ofEpochMilli(r3));     // Catch: Exception -> L9
        Intrinsics.checkNotNull(r17);     // Catch: Exception -> L9
        r4 = CastIntegerProtector.parseInt(r17);     // Catch: Exception -> L9
    L83:
        goto L10
    L7:
        Date r18 = new Date(r3);     // Catch: Exception -> L9
        SimpleDateFormat r19 = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH);     // Catch: Exception -> L9
        r19.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));     // Catch: Exception -> L9
        String r20 = r19.format(r18);     // Catch: Exception -> L9
        Intrinsics.checkNotNull(r20);     // Catch: Exception -> L9
        r4 = CastIntegerProtector.parseInt(r20);     // Catch: Exception -> L9
        goto L83
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public final String getDeviceBrand() {
        return Build.BRAND;
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public final String getDeviceModel() {
        return Build.MODEL;
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public final String getOSVersion() {
        return Build.VERSION.INCREMENTAL;
    }
}
