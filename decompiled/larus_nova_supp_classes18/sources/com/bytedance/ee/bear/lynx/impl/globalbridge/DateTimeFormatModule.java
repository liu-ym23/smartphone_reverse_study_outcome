package com.bytedance.ee.bear.lynx.impl.globalbridge;

import android.content.Context;
import android.text.TextUtils;
import c7c.b;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larksuite.framework.utils.UIUtils;
import com.lynx.jsbridge.LynxMethod;
import com.lynx.jsbridge.LynxModule;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.ss.android.lark.time.format.common.d;
import com.ss.android.lark.time.format.common.e;
import com.ss.android.lark.time.format.entity.DatePreciseness;
import com.ss.android.lark.time.format.entity.DisplayPattern;
import com.ss.android.lark.time.format.entity.LengthType;
import com.ss.android.lark.time.format.entity.TimePreciseness;
import com.ss.android.lark.utils.UIHelper;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J*\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH\u0007J\u001a\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\"\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ee/bear/lynx/impl/globalbridge/DateTimeFormatModule;", "Lcom/lynx/jsbridge/LynxModule;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "call", "", "formatMethod", "", "params", "Lcom/lynx/react/bridge/ReadableMap;", "callback", "Lcom/lynx/react/bridge/Callback;", "callbackSuccess", "formatString", "callbackFailure", "code", "", "msg", "convertParams", "Lcom/ss/android/lark/time/format/Options;", "Companion", "features-lynx-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DateTimeFormatModule extends LynxModule {
    public static final a Companion = null;
    public static final String NAME = "DateTimeFormatModule";

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public DateTimeFormatModule(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    private final c7c.a convertParams(ReadableMap r15) {
        if (r15 == null) goto L4;
        String r3 = r15.getString("timezone", "");
        DisplayPattern r0 = DisplayPattern.ABSOLUTE;
        int r1 = r15.getInt("displayPattern", r0.getNumber());
        int r2 = r15.getInt("lengthType", LengthType.LONG.getNumber());
        DatePreciseness r4 = DatePreciseness.DAY;
        int r5 = r15.getInt("datePreciseness", r4.getNumber());
        int r6 = r15.getInt("timePreciseness", TimePreciseness.MINUTE.getNumber());
        boolean r9 = r15.getBoolean("isShowTimezone", false);
        boolean r10 = r15.getBoolean("isTwelveHour", false);
        boolean r11 = r15.getBoolean("isTruncatingZeroTail", false);
        boolean r16 = r15.getBoolean("isTimeOptimize", false);
        Intrinsics.checkNotNull(r3);
        DisplayPattern.Companion.getClass();
        if (r1 == 0) goto L10;
        if (r1 != 1) goto L10;
        r0 = DisplayPattern.RELATIVE;
    L10:
        LengthType.Companion.getClass();
        LengthType r7 = LengthType.a.a(r2);
        DatePreciseness.Companion.getClass();
        if (r5 == 0) goto L15;
        if (r5 != 1) goto L15;
        DatePreciseness r8 = DatePreciseness.MONTH;
    L16:
        TimePreciseness.Companion.getClass();
        TimePreciseness r12 = TimePreciseness.a.a(r6);
        return new c7c.a(r3, r0, r7, r8, r12, r9, r10, r11, r16, 1056);
    L15:
        r8 = r4;
        goto L16
    L4:
        return d.a(null);
    }

    private final void callbackSuccess(String r5, Callback r6) {
        JavaOnlyMap r0 = new JavaOnlyMap();
        r0.put("code", 1);
        r0.put("message", "success");
        r0.put(WikiFolderPushPlugin.DATA, r5);
        if (r6 == null) goto L6;
        r6.invoke(new Object[]{r0});
        return;
    }

    private final void callbackFailure(int r3, String r4, Callback r5) {
        JavaOnlyMap r0 = new JavaOnlyMap();
        r0.put("code", Integer.valueOf(r3));
        r0.put("message", r4);
        if (r5 == null) goto L6;
        r5.invoke(new Object[]{r0});
        return;
    }

    @LynxMethod
    public final void call(String r19, ReadableMap r20, Callback r21) {
        DateTimeFormatModule r0 = this;
        if (TextUtils.isEmpty(r19) == false) goto L6;
        r0.callbackFailure(-3, "formatMethod is empty", r21);
        return;
    L6:
        String r4 = "";
        if (r20 == null) goto L10;
        String r5 = r20.getString("timestamp", "");
        if (r5 == null) goto L10;
    L11:
        if (r20 == null) goto L14;
        String r6 = r20.getString("startTimestamp", "");
        if (r6 == null) goto L14;
    L15:
        if (r20 == null) goto L18;
        String r7 = r20.getString("endTimestamp", "");
        if (r7 == null) goto L18;
    L19:
        c7c.a r2 = r0.convertParams(r20);
        if (r19 == null) goto L182;
        boolean r9 = true;
        switch(r19.hashCode()) {
            case -1948285527: goto L150;
            case -1683553519: goto L140;
            case -1117838344: goto L125;
            case -832316359: goto L110;
            case -616970015: goto L100;
            case -527493293: goto L90;
            case 323323973: goto L80;
            case 323808100: goto L70;
            case 522240939: goto L55;
            case 1302928372: goto L45;
            case 1441832137: goto L35;
            case 1765123250: goto L25;
            default: goto L182;
        };
    L25:
        if (r19.equals(FormatMethod.FORMAT_DATE_TIME) == false) goto L182;
        if (r5.length() == 0) goto L31;
        r9 = false;
    L31:
        if (r9 == true) goto L147;
        r4 = b.c(((LynxModule) r0).mContext, new Date(CastLongProtector.parseLong(r5)), r2);
    L147:
        Callback r1 = r21;
    L183:
        r0.callbackSuccess(r4, r1);
        return;
    L35:
        if (r19.equals(FormatMethod.FORMAT_MONTH) == false) goto L182;
        if (r5.length() == 0) goto L41;
        r9 = false;
    L41:
        if (r9 == true) goto L147;
        r4 = b.h(((LynxModule) r0).mContext, new Date(CastLongProtector.parseLong(r5)), r2);
        goto L147
    L45:
        if (r19.equals(FormatMethod.FORMAT_FULL_DATE) == false) goto L182;
        if (r5.length() == 0) goto L51;
        r9 = false;
    L51:
        if (r9 == true) goto L147;
        r4 = b.e(((LynxModule) r0).mContext, new Date(CastLongProtector.parseLong(r5)), r2);
        goto L147
    L55:
        if (r19.equals(FormatMethod.FORMAT_DATE_TIME_RANGE) == false) goto L182;
        if (r6.length() != 0) goto L60;
        boolean r3 = true;
    L61:
        if (r3 == true) goto L147;
        if (r7.length() == 0) goto L66;
        r9 = false;
    L66:
        if (r9 == true) goto L147;
        r4 = b.d(((LynxModule) r0).mContext, new Date(CastLongProtector.parseLong(r6)), new Date(CastLongProtector.parseLong(r7)), r2);
        goto L147
    L60:
        r3 = false;
        goto L61
    L70:
        if (r19.equals(FormatMethod.FORMAT_TIME) == false) goto L182;
        if (r5.length() == 0) goto L76;
        r9 = false;
    L76:
        if (r9 == true) goto L147;
        r4 = b.i(((LynxModule) r0).mContext, new Date(CastLongProtector.parseLong(r5)), r2);
        goto L147
    L80:
        if (r19.equals(FormatMethod.FORMAT_DATE) == false) goto L182;
        if (r5.length() == 0) goto L86;
        r9 = false;
    L86:
        if (r9 == true) goto L147;
        r4 = b.a(((LynxModule) r0).mContext, new Date(CastLongProtector.parseLong(r5)), r2);
        goto L147
    L90:
        if (r19.equals(FormatMethod.FORMAT_MERIDIEM) == false) goto L182;
        if (r5.length() == 0) goto L96;
        r9 = false;
    L96:
        if (r9 == true) goto L147;
        r4 = b.g(((LynxModule) r0).mContext, new Date(CastLongProtector.parseLong(r5)), r2);
        goto L147
    L100:
        if (r19.equals(FormatMethod.FORMAT_FULL_DATE_TIME) == false) goto L182;
        if (r5.length() == 0) goto L106;
        r9 = false;
    L106:
        if (r9 == true) goto L147;
        r4 = b.f(((LynxModule) r0).mContext, new Date(CastLongProtector.parseLong(r5)), r2);
        goto L147
    L110:
        if (r19.equals(FormatMethod.FORMAT_TIME_RANGE) == false) goto L182;
        if (r6.length() != 0) goto L115;
        boolean r8 = true;
    L116:
        if (r8 == true) goto L147;
        if (r7.length() == 0) goto L121;
        r9 = false;
    L121:
        if (r9 == true) goto L147;
        r4 = b.j(((LynxModule) r0).mContext, new Date(CastLongProtector.parseLong(r6)), new Date(CastLongProtector.parseLong(r7)), r2);
        goto L147
    L115:
        r8 = false;
        goto L116
    L125:
        if (r19.equals(FormatMethod.FORMAT_DATE_RANGE) == false) goto L182;
        if (r6.length() != 0) goto L130;
        boolean r10 = true;
    L131:
        if (r10 == true) goto L147;
        if (r7.length() == 0) goto L136;
        r9 = false;
    L136:
        if (r9 == true) goto L147;
        r4 = b.b(((LynxModule) r0).mContext, new Date(CastLongProtector.parseLong(r6)), new Date(CastLongProtector.parseLong(r7)), r2);
        goto L147
    L130:
        r10 = false;
        goto L131
    L140:
        if (r19.equals(FormatMethod.FORMAT_WEEK_DAY) == false) goto L182;
        if (r5.length() == 0) goto L146;
        r9 = false;
    L146:
        if (r9 == true) goto L147;
        r4 = b.l(((LynxModule) r0).mContext, new Date(CastLongProtector.parseLong(r5)), r2);
        goto L147
    L150:
        if (r19.equals(FormatMethod.FORMAT_FULL_DATE_RANGE) == false) goto L182;
        if (r6.length() != 0) goto L155;
        boolean r11 = true;
    L156:
        if (r11 == true) goto L182;
        if (r7.length() != 0) goto L160;
        boolean r12 = true;
    L161:
        if (r12 == true) goto L182;
        Context r13 = ((LynxModule) r0).mContext;
        Date r14 = new Date(CastLongProtector.parseLong(r6));
        Date r15 = new Date(CastLongProtector.parseLong(r7));
        int r16 = b.a;
        Intrinsics.checkNotNullParameter(r13, "context");
        Intrinsics.checkNotNullParameter(r14, "startDate");
        Intrinsics.checkNotNullParameter(r15, "endDate");
        c7c.a r17 = d.a(r2);
        int r18 = com.ss.android.lark.time.format.common.a.a;
        Context r22 = com.ss.android.lark.time.format.common.a.a(r13, r17.l);
        HashMap r23 = new HashMap();
        GregorianCalendar r110 = new GregorianCalendar(d.b(r17.a));
        r110.setTime(r14);
        GregorianCalendar r24 = new GregorianCalendar(d.b(r17.a));
        r24.setTime(r15);
        if (e.c(r110, r24) == false) goto L166;
        String r25 = b.e(r22, r14, r17);
    L174:
        r4 = r25;
        goto L182
    L166:
        String r26 = UIUtils.getString(r22, 2131887020);
        if (r17.b == DisplayPattern.ABSOLUTE) goto L169;
        TimeZone r27 = d.b(r17.a);
        GregorianCalendar r28 = new GregorianCalendar(r27);
        if (e.d(r110, r28) == true) goto L178;
    L181:
        int r111 = d7c.a.a;
        boolean r112 = r9;
        r23.put("startTime", d7c.a.c(r22, r27, r112, r110, r28, r17.j, r17.l));
        r23.put("endTime", d7c.a.c(r22, r27, r112, r24, r28, r17.j, r17.l));
        r4 = UIHelper.mustacheFormat(r26, r23);
        goto L182
    L178:
        if (e.d(r24, r28) == false) goto L181;
        r9 = false;
        goto L181
    L169:
        if (r17.c == LengthType.SHORT) goto L171;
    L173:
        r23.put("startTime", b.e(r22, r14, r17));
        r23.put("endTime", b.e(r22, r15, r17));
        r25 = UIHelper.mustacheFormat(r26, r23);
        goto L174
    L171:
        if (e.d(r110, r24) == true) goto L173;
        r17.c(LengthType.LONG);
        goto L173
    L160:
        r12 = false;
        goto L161
    L155:
        r11 = false;
    L182:
        r0 = this;
        r1 = r21;
    L18:
        r7 = "";
    L14:
        r6 = "";
    L10:
        r5 = "";
        goto L11
    }

    public static /* synthetic */ void call$default(DateTimeFormatModule r1, String r2, ReadableMap r3, Callback r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = null;
    L8:
        r1.call(r2, r3, r4);
    }
}
