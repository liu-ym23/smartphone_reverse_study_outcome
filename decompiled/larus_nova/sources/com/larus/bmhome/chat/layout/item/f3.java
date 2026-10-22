package com.larus.bmhome.chat.layout.item;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.bmhome.chat.cell.view.MessageNoBoxContainerView;
import com.larus.nova.R;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import v19.i5;

/* JADX INFO: loaded from: classes25.dex */
public final class f3 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f304353a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f304354b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c3 f304355c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f304356d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f304357e;

    public f3(View r100, int r101, c3 r102, Ref.ObjectRef r103, Ref.ObjectRef r104) {
        this.f304353a = r100;
        this.f304354b = r101;
        this.f304355c = r102;
        this.f304356d = r103;
        this.f304357e = r104;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a() {
        if (this.f304354b != this.f304355c.f304282e) goto L69;
        RecyclerView r100 = (RecyclerView) this.f304356d.element;
        View r101 = null;
        if (r100 == null) goto L55;
        int r102 = r100.getChildCount();
        int r103 = Integer.MIN_VALUE;
        View r104 = null;
        int r105 = 0;
    L8:
        if (r105 >= r102) goto L54;
        View r106 = r100.getChildAt(r105);
        Object r110 = r106.getTag(R.id.chat_list_msg_id);
        if ((r110 instanceof String) == false) goto L12;
        String r111 = (String) r110;
    L14:
        if ((r106 instanceof MessageNoBoxContainerView) == false) goto L53;
        if (r106 == this.f304357e.element) goto L53;
        MessageNoBoxContainerView r112 = (MessageNoBoxContainerView) r106;
        if (r112.getBottom() > ((View) this.f304357e.element).getTop()) goto L53;
        if (r111 == null) goto L21;
        Integer r113 = Integer.valueOf(com.larus.bmhome.social.userchat.model.b0.b(r111));
    L22:
        if (r113 != null) goto L25;
    L26:
        if (r111 != null) goto L28;
    L30:
        boolean r114 = false;
    L31:
        if (r114 == true) goto L34;
        boolean r115 = false;
    L35:
        if (r113 != null) goto L38;
    L39:
        if (r111 != null) goto L41;
    L43:
        boolean r116 = false;
    L44:
        if (r116 == true) goto L47;
        boolean r117 = false;
    L48:
        if (r115 == true) goto L51;
        if (r117 == false) goto L53;
    L51:
        if (r112.getBottom() < r103) goto L53;
        r103 = r112.getBottom();
        r104 = r106;
    L47:
        r117 = true;
        goto L48
    L41:
        if (StringsKt.contains$default(r111, "-clear-context", false, 2, null) != true) goto L43;
        r116 = true;
        goto L44
    L38:
        if (r113.intValue() == 3) goto L47;
    L34:
        r115 = true;
        goto L35
    L28:
        if (StringsKt.contains$default(r111, "-welcome-back", false, 2, null) != true) goto L30;
        r114 = true;
        goto L31
    L25:
        if (r113.intValue() == 4) goto L34;
    L21:
        r113 = null;
    L53:
        r105 = r105 + 1;
        goto L8
    L12:
        r111 = null;
        goto L14
    L54:
        r101 = r104;
    L55:
        List<? extends View> r107 = CollectionsKt.distinct(CollectionsKt.listOfNotNull(new View[]{r101, this.f304357e.element}));
        View r108 = (View) CollectionsKt.lastOrNull(r107);
        this.f304355c.f304283f = r107;
        Iterator<T> r109 = r107.iterator();
    L57:
        if (r109.hasNext() == false) goto L59;
        View r118 = (View) r109.next();
        r118.animate().cancel();
        r118.setAlpha(0.0f);
        r118.setTranslationY(i5.h());
        goto L57
    L59:
        ((View) this.f304357e.element).post(new e3(this.f304354b, this.f304355c, r107, r108));
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
