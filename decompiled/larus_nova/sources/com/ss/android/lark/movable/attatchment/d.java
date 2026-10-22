package com.ss.android.lark.movable.attatchment;

import android.content.Context;
import android.graphics.Rect;
import android.widget.FrameLayout;
import com.ss.android.lark.movable.MovableView;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class d extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MovableView f432636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f432637b;

    public static final class a {
    }

    static {
    }

    public final com.ss.android.lark.movable.b getMovableEventClickListener() {
        return this.f432636a.getRootMovableView().getEventClickListener$movable_release();
    }

    public Rect getRect() {
        b r100 = this.f432637b;
        if (r100 != null) goto L6;
        return null;
    L6:
        float r101 = r100.f432627c;
        float r102 = r100.f432628d;
        return new Rect((int) r101, (int) r102, ((int) r101) + ((int) r100.f432629e), ((int) r102) + ((int) r100.f432630f));
    }

    public final b getAttachmentInfo$movable_release() {
        return this.f432637b;
    }

    public final MovableView getMovableView() {
        return this.f432636a;
    }

    public final void setAttachmentInfo$movable_release(b r100) {
        this.f432637b = r100;
    }

    public d(Context r100, MovableView r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "movableView");
        super(r100);
        this.f432636a = r101;
    }

    public final void a(b r100, List<? extends IAttachmentBinder> r101) {
        Intrinsics.checkNotNullParameter(r100, "attachmentInfo");
        this.f432637b = r100;
        if (r101 == null) goto L17;
        Iterator<T> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L13;
        Object r103 = r102.next();
        if (((IAttachmentBinder) r103).getAttachmentTypeId() != r100.f432625a) goto L10;
        boolean r104 = true;
    L11:
        if (r104 == false) goto L6;
    L14:
        IAttachmentBinder r105 = (IAttachmentBinder) r103;
        if (r105 == null) goto L17;
        r105.bind(this, r100);
        return;
    L10:
        r104 = false;
        goto L11
    L13:
        r103 = null;
    L17:
        IAttachmentBinder.Companion r106 = IAttachmentBinder.f432604a;
        int r107 = r100.f432625a;
        r106.getClass();
        IAttachmentBinder r108 = IAttachmentBinder.Companion.f432606b.getValue().get(Integer.valueOf(r107));
        if (r108 == null) goto L27;
        r108.bind(this, r100);
        return;
    }
}
