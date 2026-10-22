package com.larus.livetutor.impl.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\u0011\u001a\u00020\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0013J\b\u0010\u0014\u001a\u00020\u0010H\u0002J\u0016\u0010\u0015\u001a\u00020\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0013H\u0002J&\u0010\u0016\u001a\u00020\u00102\u001e\u0010\r\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b\u0012\u0004\u0012\u00020\u00100\u000eR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\r\u001a\u001c\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/larus/livetutor/impl/view/TutorStarListWithTitleView;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "titleList", "", "Lcom/larus/livetutor/impl/view/TutorStarTitleView;", "listener", "Lkotlin/Function2;", "Lcom/larus/livetutor/impl/view/TutorStarItem;", "", "updateData", "data", "", "changeTitlePosition", "updateTitleUI", "setOnItemSelectedListener", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TutorStarListWithTitleView extends LinearLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f356802c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<TutorStarTitleView> f356803a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function2<? super Integer, ? super List<m2>, Unit> f356804b;

    public TutorStarListWithTitleView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public TutorStarListWithTitleView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void a(List<m2> r100) {
        ListIterator<m2> r101 = r100.listIterator(r100.size());
    L4:
        if (r101.hasPrevious() == false) goto L8;
        if (r101.previous().f356872c == false) goto L4;
        int r102 = r101.nextIndex();
    L9:
        Iterator<T> r103 = this.f356803a.iterator();
        int r104 = 0;
    L11:
        if (r103.hasNext() == false) goto L23;
        Object r105 = r103.next();
        int r106 = r104 + 1;
        if (r104 >= 0) goto L15;
        CollectionsKt.throwIndexOverflow();
    L15:
        TutorStarTitleView r107 = (TutorStarTitleView) r105;
        if (r104 == r102) goto L18;
        boolean r108 = true;
    L19:
        if (r108 == false) goto L21;
        int r109 = 4;
    L22:
        r107.setVisibility(r109);
        r104 = r106;
        goto L11
    L21:
        r109 = 0;
        goto L22
    L18:
        r108 = false;
        goto L19
    L23:
        return;
    L8:
        r102 = -1;
        goto L9
    }

    public final void setOnItemSelectedListener(Function2<? super Integer, ? super List<m2>, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f356804b = r100;
    }

    public TutorStarListWithTitleView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f356803a = new ArrayList();
        LinearLayout.inflate(r100, R.layout.star_list_with_title_layout, this);
        setGravity(1);
        setOrientation(1);
        TutorStarListView r103 = (TutorStarListView) findViewById(R.id.star_list);
        if (r103 == null) goto L5;
        r103.setDecorationChangeListener$impl_mainlandRelease(new q2(this));
        r103.setOnItemSelectedListener(new r2(this));
    L5:
        setClipChildren(false);
        setClipToPadding(false);
    }

    public /* synthetic */ TutorStarListWithTitleView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
