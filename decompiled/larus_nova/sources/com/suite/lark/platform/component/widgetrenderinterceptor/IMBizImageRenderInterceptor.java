package com.suite.lark.platform.component.widgetrenderinterceptor;

import android.content.Context;
import android.widget.ImageView;
import com.ss.android.lark.widget.span.nopreview.UnAuthorizationDrawableWrapper;
import com.suite.lark.platform.component.widgetrenderinterceptor.entity.BizInterceptorType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public interface IMBizImageRenderInterceptor {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/suite/lark/platform/component/widgetrenderinterceptor/IMBizImageRenderInterceptor$Scene;", "", "<init>", "(Ljava/lang/String;I)V", "BeforeRender", "AfterRender", "widget-biz-renderinterceptor_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Scene extends Enum<Scene> {
        public static final Scene AfterRender = null;
        public static final Scene BeforeRender = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Scene[] f461182a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f461183b = null;

        public static EnumEntries<Scene> getEntries() {
            return f461183b;
        }

        static {
            Scene r100 = new Scene("BeforeRender", 0);
            BeforeRender = r100;
            Scene r101 = new Scene("AfterRender", 1);
            AfterRender = r101;
            Scene[] r102 = {r100, r101};
            f461182a = r102;
            f461183b = EnumEntriesKt.enumEntries(r102);
        }

        public static Scene[] values() {
            return (Scene[]) f461182a.clone();
        }

        public static Scene valueOf(String r100) {
            return (Scene) r27.a.a(Scene.class, r100);
        }

        public Scene(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface a {
        ImageView a();
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f461184a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f461185b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final UnAuthorizationDrawableWrapper.Style f461186c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f461187d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f461184a == r101.f461184a) goto L12;
            return false;
        L12:
            if (this.f461185b == r101.f461185b) goto L15;
            return false;
        L15:
            if (this.f461186c == r101.f461186c) goto L18;
            return false;
        L18:
            if (this.f461187d == r101.f461187d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((this.f461184a * 31) + this.f461185b) * 31) + this.f461186c.hashCode()) * 31;
            if (this.f461187d == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "SizeConfig(width=" + this.f461184a + ", height=" + this.f461185b + ", style=" + this.f461186c + ", hasBorder=" + this.f461187d + ')';
        }

        public b(int r100, int r101, UnAuthorizationDrawableWrapper.Style r102) {
            Intrinsics.checkNotNullParameter(r102, "style");
            this.f461184a = r100;
            this.f461185b = r101;
            this.f461186c = r102;
            this.f461187d = false;
        }
    }

    Function0<Boolean> a(Context r100, a r101, kpc.a r102);

    Function0<Boolean> b(Context r100, a r101, kpc.a r102, b r103);

    Scene c();

    BizInterceptorType getType();
}
