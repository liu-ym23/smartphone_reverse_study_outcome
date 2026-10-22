package com.ss.android.lark.widget.span;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.util.Linkify;
import androidx.core.text.util.LinkifyCompat;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.widget.utils.PhoneParseUtils;
import io.michaelrocks.libphonenumber.android.PhoneNumberMatcher;
import io.michaelrocks.libphonenumber.android.PhoneNumberUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class g0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Pattern f448681d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Pattern f448682e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Pattern f448683f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<SpanInfo> f448684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Boolean f448685b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Boolean f448686c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g0 f448687a = null;

        static {
            f448687a = new g0();
        }
    }

    static {
        f448681d = PatternProtector.compile(n0.f448716c);
        PatternProtector.compile(n0.f448717d);
        f448682e = com.ss.android.lark.utils.o.f444744a;
        f448683f = PatternProtector.compile("\\+[0-9]{10,18},{1,3}[0-9]{9,}#|400[0-9]{7},{1,3}[0-9]{9,}#");
        PatternProtector.compile("<chat.*?[^>]chat_id=\\\"([\\s\\S]*?)\">([\\s\\S]*?)</chat>");
        FeatureGatingModule.getFeatureGatingService().isEnable("im.messenger.url_pattern_regex");
    }

    public static boolean d() {
        SpannableString r100 = new SpannableString("13700000000");
        Linkify.addLinks(r100, 4);
        ClickableSpan[] r101 = (ClickableSpan[]) r100.getSpans(0, r100.length(), ClickableSpan.class);
        if (r101 != null) goto L5;
        return false;
    L5:
        if (r101.length <= 0) goto L9;
        return true;
    L9:
        return false;
    }

    public g0() {
        this.f448684a = new ArrayList();
        this.f448685b = null;
        this.f448686c = null;
    }

    public static void a(List r100, List r101) {
        if (CollectionUtils.isNotEmpty(r101) == false) goto L6;
        r100.addAll(r101);
        return;
    }

    public static boolean c(SpanInfo r100, List r101) {
        if (CollectionUtils.isNotEmpty(r101) == false) goto L26;
        int r102 = 0;
    L6:
        if (r102 >= r101.size()) goto L34;
        SpanInfo r103 = (SpanInfo) ListProtector.get(r101, r102);
        if (r103.isGlobalSpanInfo == true) goto L25;
        int r104 = ((SpanInfo) ListProtector.get(r101, r102)).start;
        int r105 = ((SpanInfo) ListProtector.get(r101, r102)).end;
        int r106 = r100.type;
        if (r106 == 2) goto L14;
        if (r106 == 1) goto L14;
    L18:
        boolean r107 = false;
    L19:
        if (r107 == true) goto L25;
        if (r100.start >= r105) goto L25;
        if (r100.end <= r104) goto L25;
        return false;
    L14:
        if ((r103 instanceof AbbreviationInfo) == false) goto L18;
        if (((AbbreviationInfo) r103).bizType != AbbreviationInfo.AbbreviationType.CALENDAR) goto L18;
        r107 = true;
    L25:
        r102 = r102 + 1;
        goto L6
    L34:
        return true;
    L26:
        return true;
    }

    public static List e(String r100, List r101) {
        ArrayList r102 = new ArrayList();
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return r102;
    L5:
        Matcher r103 = f448682e.matcher(r100);
    L7:
        if (r103.find() == false) goto L11;
        AtInfo r104 = new AtInfo();
        r104.start = r103.start();
        r104.end = r103.end();
        r104.userId = r103.group(1);
        r104.text = r103.group(2);
        r104.type = 0;
        if (c(r104, r101) == false) goto L7;
        r102.add(r104);
        goto L7
    L11:
        return r102;
    }

    public final List<PhoneInfo> f(String r110, List<SpanInfo> r111) {
        ArrayList r100 = new ArrayList();
        ArrayList r101 = new ArrayList();
        if (TextUtils.isEmpty(r110) == false) goto L5;
        return r100;
    L5:
        Matcher r102 = f448683f.matcher(r110);
    L7:
        if (r102.find() == false) goto L11;
        PhoneInfo r103 = new PhoneInfo();
        r103.start = r102.start();
        r103.end = r102.end();
        r103.text = r102.group();
        r103.type = 2;
        if (c(r103, r111) == false) goto L7;
        r100.add(r103);
        r101.add(r103);
        goto L7
    L11:
        int r104 = r100.size();
        Lazy r105 = PhoneParseUtils.f449072a;
        if (FeatureGatingModule.getFeatureGatingService().isEnable("messenger.richtext.phone_parse_v2") == false) goto L31;
        Log.i("SpanInfoParser", "parsePhoneSpan: usePhoneNumberUtils");
        SpannableString r106 = new SpannableString(r110);
        Intrinsics.checkNotNullParameter(r106, PickerReporterConstants.KEY.TARGET);
        Locale r112 = xbc.a.a().getCachedLocale();
        if (r112 == null) goto L17;
        String r113 = r112.getCountry();
        if (r113 == null) goto L17;
    L18:
        PhoneNumberUtil r107 = (PhoneNumberUtil) PhoneParseUtils.f449072a.getValue();
        PhoneNumberUtil.Leniency r108 = PhoneNumberUtil.Leniency.POSSIBLE;
        r107.getClass();
        io.michaelrocks.libphonenumber.android.h r109 = new io.michaelrocks.libphonenumber.android.h(r107, r106, r113, r108);
        ArrayList r114 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r109, 10));
        Iterator<io.michaelrocks.libphonenumber.android.g> r115 = r109.iterator();
    L19:
        PhoneNumberMatcher r116 = (PhoneNumberMatcher) r115;
        if (r116.hasNext() == false) goto L22;
        io.michaelrocks.libphonenumber.android.g r117 = (io.michaelrocks.libphonenumber.android.g) r116.next();
        PhoneInfo r118 = new PhoneInfo();
        String r119 = r117.f492248b;
        r118.text = r119;
        int r120 = r117.f492247a;
        r118.start = r120;
        r118.end = r120 + r119.length();
        r118.type = 2;
        r114.add(r118);
        goto L19
    L22:
        Iterator r121 = r114.iterator();
    L24:
        if (r121.hasNext() == false) goto L61;
        PhoneInfo r122 = (PhoneInfo) r121.next();
        if (c(r122, r111) == false) goto L24;
        if (c(r122, r101) == false) goto L24;
        r100.add(r122);
        r101.add(r122);
    L61:
        Log.i("SpanInfoParser", "parsePhoneSpan: phone info size " + r100.size() + " , vc regex find size " + r104);
        return r100;
    L17:
        Log.w("LinkedEmoji:PhoneParseUtils", "findAllPhoneNumbers: use default country");
        r113 = Locale.getDefault().getCountry();
        goto L18
    L31:
        if (this.f448685b != null) goto L34;
        this.f448685b = Boolean.valueOf(d());
    L34:
        if (this.f448686c != null) goto L36;
        this.f448686c = Boolean.valueOf(FeatureGatingModule.getFeatureGatingService().isEnable("im.message.rich_text_detect_phone_new"));
    L36:
        int r123 = 0;
        if (this.f448685b.booleanValue() == false) goto L53;
        Log.i("SpanInfoParser", "parsePhoneSpan: use system phone parse");
        SpannableString r124 = new SpannableString(r110);
        ArrayList r125 = new ArrayList();
        if (this.f448686c.booleanValue() == false) goto L41;
        LinkifyCompat.addLinks(r124, com.ss.android.lark.widget.utils.a.a(true), "tel:");
    L42:
        ClickableSpan[] r126 = (ClickableSpan[]) r124.getSpans(0, r124.length(), ClickableSpan.class);
        int r127 = r126.length;
    L43:
        if (r123 >= r127) goto L45;
        ClickableSpan r128 = r126[r123];
        int r129 = r124.getSpanStart(r128);
        int r130 = r124.getSpanEnd(r128);
        PhoneInfo r131 = new PhoneInfo();
        r131.start = r129;
        r131.end = r130;
        r131.text = r110.substring(r129, r130);
        r131.type = 2;
        r125.add(r131);
        r123 = r123 + 1;
        goto L43
    L45:
        Iterator r132 = r125.iterator();
    L47:
        if (r132.hasNext() == false) goto L61;
        PhoneInfo r133 = (PhoneInfo) r132.next();
        if (c(r133, r111) == false) goto L47;
        if (c(r133, r101) == false) goto L47;
        r100.add(r133);
        r101.add(r133);
        goto L47
    L41:
        LinkifyCompat.addLinks(r124, 4);
        goto L42
    L53:
        Log.i("SpanInfoParser", "parsePhoneSpan: use regex phone parse");
        Matcher r134 = com.ss.android.lark.widget.utils.a.a(false).matcher(r110);
    L55:
        if (r134.find() == false) goto L61;
        PhoneInfo r135 = new PhoneInfo();
        r135.start = r134.start();
        r135.end = r134.end();
        r135.text = r134.group();
        r135.type = 2;
        if (c(r135, r111) == false) goto L55;
        if (c(r135, r101) == false) goto L55;
        r100.add(r135);
        goto L55
    }

    public static List h(String r100, List r101, List r102) {
        ArrayList r103 = new ArrayList();
        if (CollectionUtils.isEmpty(r101) == false) goto L10;
        Matcher r104 = f448681d.matcher(r100);
    L6:
        if (r104.find() == false) goto L23;
        UrlInfo r105 = new UrlInfo();
        r105.start = r104.start();
        r105.end = r104.end();
        r105.text = r104.group();
        r105.href = r104.group();
        r105.type = 1;
        if (c(r105, r102) == false) goto L6;
        r103.add(r105);
    L23:
        return r103;
    L10:
        String r106 = r100.toString();
        Iterator r107 = ((ArrayList) r101).iterator();
    L12:
        if (r107.hasNext() == false) goto L23;
        MessageUrlPreview r108 = (MessageUrlPreview) r107.next();
        UrlInfo r109 = new UrlInfo();
        r109.type = 1;
        r109.text = r108.getUrl();
        r109.start = r108.getOffset();
        r109.end = r108.getCount() + r108.getOffset();
        if (r109.start >= r106.length()) goto L12;
        if (r109.start < 0) goto L12;
        int r110 = r109.end;
        if (r110 < 0) goto L12;
        if (r110 > r106.length()) goto L12;
        r103.add(r109);
        goto L12
    }

    public final List b(List r100, List r101, List r102) {
        ArrayList r103 = new ArrayList();
        if (r100 != null) goto L5;
        r100 = this.f448684a;
    L5:
        r103.addAll(r100);
        r103.addAll(r101);
        r103.addAll(this.f448684a);
        r103.addAll(r102);
        return r103;
    }

    public final RecogniseSpansResult g(String r310, List<MessageUrlPreview> r311, boolean r312, String r313) {
        if (TextUtils.isEmpty(r310) == false) goto L5;
        return null;
    L5:
        f0 r100 = f0.a.f448675a;
        RecogniseSpansResult r101 = r100.a(r310);
        boolean r102 = true;
        if (r101 != null) goto L9;
    L12:
        if (r102 == true) goto L14;
        return r101;
    L14:
        List<AtInfo> r103 = e(r310, null);
        ArrayList r104 = new ArrayList();
        List r105 = h(r310, r311, b(null, r103, r104));
        List r106 = b(r105, r103, r104);
        new ArrayList();
        new ArrayList();
        ArrayList r107 = new ArrayList();
        new ArrayList();
        ArrayList r110 = new ArrayList();
        ArrayList r111 = new ArrayList();
        ArrayList r112 = new ArrayList();
        ArrayList r113 = new ArrayList();
        ArrayList r114 = new ArrayList();
        ArrayList r115 = new ArrayList();
        ArrayList r116 = new ArrayList();
        ArrayList r117 = new ArrayList();
        ArrayList r118 = new ArrayList();
        ArrayList r210 = new ArrayList();
        ArrayList r211 = new ArrayList();
        ArrayList r212 = new ArrayList();
        ArrayList r213 = new ArrayList();
        ArrayList r214 = new ArrayList();
        ArrayList r215 = new ArrayList();
        ArrayList r216 = new ArrayList();
        ArrayList r217 = new ArrayList();
        ArrayList r218 = new ArrayList();
        ArrayList r219 = new ArrayList();
        ArrayList r314 = new ArrayList();
        ArrayList r315 = new ArrayList();
        ArrayList r316 = new ArrayList();
        if (r312 == false) goto L17;
        List<PhoneInfo> r108 = f(r310, r106);
    L18:
        RecogniseSpansResult r109 = new RecogniseSpansResult(r105, r103, r108, r104, r110, r111, r112, r113, r114, r115, r116, r117, r118, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r314, r315, r316);
        if (CollectionUtils.isEmpty(r109.getAllSpanInfos()) == true) goto L24;
        r100.b(r310, r109);
        RecogniseSpansResult r119 = r100.a(r313);
        if (r119 == null) goto L24;
        r119.addAtSpanInfos(r103);
        r119.addPhoneSpanInfos(r109.getPhoneSpanInfos());
        r119.addChatSpanInfos(r104);
        return r119;
    L24:
        return r109;
    L17:
        r108 = r107;
        goto L18
    L9:
        if (CollectionUtils.isEmpty(r101.getAllSpanInfos()) == true) goto L12;
        r102 = false;
        goto L12
    }
}
