package io.noties.markwon.scrollable;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.ss.android.lark.utils.statistics.PerfLog;
import ctc.a;
import ctc.b;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lio/noties/markwon/scrollable/ScrollableSpanTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", SlcElement.KEY_ATTR, "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "markwon-core_release"}, k = 1, mv = {1, 4, 0})
public class ScrollableSpanTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f492654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f492655b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f492656c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f492657d;

    public ScrollableSpanTextView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ScrollableSpanTextView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        if (r100 == null) goto L42;
        boolean r101 = false;
        if (r100.getActionMasked() != 0) goto L19;
        int r102 = b.f465383a;
        a[] r103 = (a[]) b.a.a(r100, this, a.class);
        if (r103 == null) goto L40;
        int r104 = r103.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L13;
        if (r103[r105].a() == true) goto L11;
        r105 = r105 + 1;
        goto L8
    L11:
        r101 = true;
    L13:
        if (r101 != true) goto L40;
        ViewParent r106 = getParent();
        if (r106 == null) goto L17;
        r106.requestDisallowInterceptTouchEvent(true);
    L17:
        this.f492654a = true;
    L40:
        this.f492656c = r100.getX();
        this.f492657d = r100.getY();
        goto L42
    L19:
        if (r100.getActionMasked() != 2) goto L35;
        float r107 = r100.getX() - this.f492656c;
        float r108 = r100.getY() - this.f492657d;
        if (this.f492655b == true) goto L40;
        if (this.f492654a == false) goto L40;
        if (Math.abs(r108) <= Math.abs(r107)) goto L40;
        ViewParent r109 = getParent();
        if (r109 == null) goto L29;
        r109.requestDisallowInterceptTouchEvent(false);
    L29:
        ViewParent r110 = getParent();
    L31:
        if ((r110 instanceof ViewGroup) == false) goto L33;
        r110 = ((ViewGroup) r110).getParent();
        goto L31
    L33:
        this.f492655b = true;
        goto L40
    L35:
        if (r100.getActionMasked() != 1) goto L40;
        ViewParent r111 = getParent();
        if (r111 == null) goto L39;
        r111.requestDisallowInterceptTouchEvent(false);
    L39:
        this.f492654a = false;
        this.f492655b = false;
    L42:
        return super.dispatchTouchEvent(r100);
    }

    public ScrollableSpanTextView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }

    public /* synthetic */ ScrollableSpanTextView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
