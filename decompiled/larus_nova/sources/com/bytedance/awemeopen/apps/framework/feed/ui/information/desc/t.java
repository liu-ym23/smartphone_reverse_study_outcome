package com.bytedance.awemeopen.apps.framework.feed.ui.information.desc;

import com.bytedance.awemeopen.bizmodels.feed.video.TextExtraStruct;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class t extends com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final tz3.b<a> f196119a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final tz3.b<Boolean> f196120b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final tz3.b<Unit> f196121c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final tz3.b<Unit> f196122d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final tz3.b<Unit> f196123e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function0<Integer> f196124f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function0<Integer> f196125g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Function0<Integer> f196126h;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CharSequence f196127a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<TextExtraStruct> f196128b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f196127a, r101.f196127a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f196128b, r101.f196128b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f196127a.hashCode() * 31;
            List<TextExtraStruct> r101 = this.f196128b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "DescBean(desc=" + this.f196127a + ", textExtraList=" + this.f196128b + ')';
        }

        public a(CharSequence r100, List<TextExtraStruct> r101) {
            Intrinsics.checkNotNullParameter(r100, SocialConstants.PARAM_APP_DESC);
            this.f196127a = r100;
            this.f196128b = r101;
        }
    }

    public t() {
        this.f196119a = new tz3.b();
        this.f196120b = new tz3.b();
        this.f196121c = new tz3.b();
        this.f196122d = new tz3.b();
        this.f196123e = new tz3.b();
        new ArrayList();
    }
}
