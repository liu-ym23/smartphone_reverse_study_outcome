package com.ss.android.lark.keyboard.edittext2.copy;

import com.bytedance.lark.pb.im.v1.ResourceExtraInfo;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public interface a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f428969a = null;

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.edittext2.copy.a$a, reason: collision with other inner class name */
    public static final class C5087a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final RichText f428970a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<ResourceExtraInfo> f428971b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C5087a) == true) goto L8;
            return false;
        L8:
            C5087a r101 = (C5087a) r100;
            if (Intrinsics.areEqual(this.f428970a, r101.f428970a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f428971b, r101.f428971b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f428970a.hashCode() * 31) + this.f428971b.hashCode();
        }

        public final String toString() {
            return "HtmlParseResult(richText=" + this.f428970a + ", resourcesExtraInfo=" + this.f428971b + ')';
        }

        public C5087a(RichText r100, List<ResourceExtraInfo> r101) {
            Intrinsics.checkNotNullParameter(r100, "richText");
            Intrinsics.checkNotNullParameter(r101, "resourcesExtraInfo");
            this.f428970a = r100;
            this.f428971b = r101;
        }
    }

    public static final class b implements a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ b f428972c = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CopyProtocolServiceImpl f428973b;

        static {
            f428972c = new b();
        }

        public b() {
            this.f428973b = new CopyProtocolServiceImpl();
        }
    }

    static {
        f428969a = b.f428972c;
    }
}
