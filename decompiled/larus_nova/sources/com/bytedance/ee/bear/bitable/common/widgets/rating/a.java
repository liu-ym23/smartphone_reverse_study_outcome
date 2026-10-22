package com.bytedance.ee.bear.bitable.common.widgets.rating;

import android.text.TextUtils;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import com.tencent.connect.common.Constants;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, b> f210055a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, c> f210056b = null;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.bitable.common.widgets.rating.a$a, reason: collision with other inner class name */
    public static final class C3021a {
        public static b a(String r100) {
            if (r100 == null) goto L9;
            Map<String, b> r101 = a.f210055a;
            b r102 = r101.get(r100);
            if (r102 == null) goto L7;
            return r102;
        L7:
            return r101.get(ScoreTags.SCORE_TYPE_STAR);
        L9:
            return a.f210055a.get(ScoreTags.SCORE_TYPE_STAR);
        }

        public static c b(String r100) {
            if (r100 != null) goto L4;
            return null;
        L4:
            return a.f210056b.get(r100);
        }

        public static boolean c(String r100) {
            return TextUtils.equals("number", r100);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f210057a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f210058b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f210057a == r101.f210057a) goto L12;
            return false;
        L12:
            if (this.f210058b == r101.f210058b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f210057a * 31) + this.f210058b;
        }

        public final String toString() {
            return "NormalIconResInfo(selectedResId=" + this.f210057a + ", unSelectedColorResId=" + this.f210058b + ')';
        }

        public b(int r100) {
            this.f210057a = r100;
            this.f210058b = R.color.ud_N300;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f210059a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f210060b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f210061c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (this.f210059a == r101.f210059a) goto L12;
            return false;
        L12:
            if (this.f210060b == r101.f210060b) goto L15;
            return false;
        L15:
            if (this.f210061c == r101.f210061c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f210059a * 31) + this.f210060b) * 31) + this.f210061c;
        }

        public final String toString() {
            return "NpsIconResInfo(selectedBgResId=" + this.f210059a + ", selectedContentResId=" + this.f210060b + ", unSelectedBgColorResId=" + this.f210061c + ')';
        }

        public c(int r100, int r101, int r102) {
            this.f210059a = r100;
            this.f210060b = r101;
            this.f210061c = r102;
        }
    }

    static {
        f210055a = MapsKt.mapOf(new Pair[]{TuplesKt.to(ScoreTags.SCORE_TYPE_STAR, new b(R.drawable.ud_icon_rating_star_colorful)), TuplesKt.to("heart", new b(R.drawable.ud_icon_rating_like_colorful)), TuplesKt.to("thumbsup", new b(R.drawable.ud_icon_rating_thumbsup_colorful)), TuplesKt.to("fire", new b(R.drawable.ud_icon_rating_hot_colorful)), TuplesKt.to("flower", new b(R.drawable.ud_icon_rating_flower_colorful)), TuplesKt.to("smile", new b(R.drawable.ud_icon_rating_smile_colorful)), TuplesKt.to("lightning", new b(R.drawable.ud_icon_rating_speed_colorful))});
        f210056b = MapsKt.mapOf(new Pair[]{TuplesKt.to("preview", new c(R.drawable.ud_icon_rating_nps_colorful, 1, 2)), TuplesKt.to("0", new c(R.drawable.ud_icon_rating_bg_colorful, R.drawable.ud_icon_rating_0_colorful, R.color.ud_N300)), TuplesKt.to("1", new c(R.drawable.ud_icon_rating_bg_colorful, R.drawable.ud_icon_rating_1_colorful, R.color.ud_N300)), TuplesKt.to("2", new c(R.drawable.ud_icon_rating_bg_colorful, R.drawable.ud_icon_rating_2_colorful, R.color.ud_N300)), TuplesKt.to("3", new c(R.drawable.ud_icon_rating_bg_colorful, R.drawable.ud_icon_rating_3_colorful, R.color.ud_N300)), TuplesKt.to("4", new c(R.drawable.ud_icon_rating_bg_colorful, R.drawable.ud_icon_rating_4_colorful, R.color.ud_N300)), TuplesKt.to("5", new c(R.drawable.ud_icon_rating_bg_colorful, R.drawable.ud_icon_rating_5_colorful, R.color.ud_N300)), TuplesKt.to("6", new c(R.drawable.ud_icon_rating_bg_colorful, R.drawable.ud_icon_rating_6_colorful, R.color.ud_N300)), TuplesKt.to("7", new c(R.drawable.ud_icon_rating_bg_colorful, R.drawable.ud_icon_rating_7_colorful, R.color.ud_N300)), TuplesKt.to("8", new c(R.drawable.ud_icon_rating_bg_colorful, R.drawable.ud_icon_rating_8_colorful, R.color.ud_N300)), TuplesKt.to(Constants.VIA_SHARE_TYPE_MINI_PROGRAM, new c(R.drawable.ud_icon_rating_bg_colorful, R.drawable.ud_icon_rating_9_colorful, R.color.ud_N300)), TuplesKt.to(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, new c(R.drawable.ud_icon_rating_bg_colorful, R.drawable.ud_icon_rating_10_colorful, R.color.ud_N300))});
    }
}
