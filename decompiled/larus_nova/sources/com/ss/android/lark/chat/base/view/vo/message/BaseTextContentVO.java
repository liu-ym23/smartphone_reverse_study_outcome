package com.ss.android.lark.chat.base.view.vo.message;

import android.text.Layout;
import com.bytedance.lark.pb.basic.v1.File;
import com.ss.android.lark.chat.entity.message.MessageUrlPreview;
import com.ss.android.lark.chat.entity.message.PartialReplyInfo;
import com.ss.android.lark.chat.entity.message.content.BaseTextContent;
import com.ss.android.lark.doc.entity.DocResult;
import com.ss.android.lark.export.entity.PreviewHangPoint;
import com.ss.android.lark.widget.EllipsizeFrameLayout;
import com.ss.android.lark.widget.richtext.RichText;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public abstract class BaseTextContentVO<T extends BaseTextContent<T>> extends f<T> {
    public transient boolean A;
    public final Map<String, xcb.b> B;
    public Map<String, PreviewHangPoint> C;
    public Boolean D;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public MessageUrlPreview f411872h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public DocResult f411873i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public PreviewHangPoint f411874j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f411875k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f411876l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f411877m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public List<String> f411878n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public List<String> f411879o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f411880p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f411881q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f411882r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public EllipsizeFrameLayout.a f411883s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public transient CharSequence f411884t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public transient CharSequence f411885u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public transient PartialReplyInfo.PartialContentRelativePosition f411886v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public transient String f411887w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public transient String f411888x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public transient boolean f411889y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public transient Layout f411890z;

    @Target({ElementType.TYPE, ElementType.METHOD, ElementType.TYPE_USE})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/chat/base/view/vo/message/BaseTextContentVO$PreviewType;", "", "Companion", "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.PROPERTY, AnnotationTarget.TYPE, AnnotationTarget.FUNCTION})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface PreviewType {
        public static final a Companion = null;
        public static final int DOC = 2;
        public static final int NET = 4;
        public static final int NORMAL = 1;
        public static final int UNKNOWN = 0;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f411891a = null;

            static {
                f411891a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.f411891a;
        }
    }

    public final ArrayList<File> f() {
        return (ArrayList) this.f411876l.getValue();
    }

    public final RichText g() {
        return (RichText) this.f411875k.getValue();
    }

    public BaseTextContentVO(final T r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        super(r100);
        this.f411875k = LazyKt.lazy(new BaseTextContentVO$richText$2(r100));
        this.f411876l = LazyKt.lazy(new BaseTextContentVO$attachments$2(r100));
        this.f411877m = LazyKt.lazy(new BaseTextContentVO$textInMemory$2(r100));
        this.f411878n = new ArrayList();
        this.f411879o = new ArrayList();
        this.f411882r = true;
        this.f411883s = new EllipsizeFrameLayout.a();
        this.B = new LinkedHashMap();
        this.C = new LinkedHashMap();
    }

    @Override // com.ss.android.lark.chat.base.view.vo.message.f, v5b.a
    public boolean d(v5b.a<?> r100) {
        if (super.d(r100) == true) goto L6;
        return false;
    L6:
        if ((r100 instanceof BaseTextContentVO) == false) goto L27;
        BaseTextContentVO r101 = (BaseTextContentVO) r100;
        if (y28.a.a(g(), r101.g()) == true) goto L10;
        return false;
    L10:
        if (y28.a.a((String) this.f411877m.getValue(), (String) r101.f411877m.getValue()) == true) goto L12;
        return false;
    L12:
        if (this.f411880p == r101.f411880p) goto L14;
        return false;
    L14:
        if (this.f411881q == r101.f411881q) goto L16;
        return false;
    L16:
        if (this.f411882r == r101.f411882r) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f411883s, r101.f411883s) == true) goto L20;
        return false;
    L20:
        if (y28.a.a(this.f411878n, r101.f411878n) == true) goto L22;
        return false;
    L22:
        if (y28.a.a(this.f411879o, r101.f411879o) == true) goto L24;
        return false;
    L24:
        if (y28.a.a(f(), r101.f()) == false) goto L36;
        return true;
    L36:
        return false;
    L27:
        return false;
    }
}
