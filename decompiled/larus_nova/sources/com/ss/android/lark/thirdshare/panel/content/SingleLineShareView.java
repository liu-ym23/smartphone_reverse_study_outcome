package com.ss.android.lark.thirdshare.panel.content;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fJ\u0016\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/thirdshare/panel/content/SingleLineShareView;", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/ss/android/lark/thirdshare/panel/content/ShareView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adapter", "Lcom/ss/android/lark/thirdshare/panel/content/ShareItemAdapter;", "setShareItems", "", "items", "", "Lcom/ss/android/lark/thirdshare/panel/content/ShareItemContent;", "third-share-panel_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SingleLineShareView extends RecyclerView implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ShareItemAdapter f441287a;

    public SingleLineShareView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        ShareItemAdapter r101 = new ShareItemAdapter();
        this.f441287a = r101;
        c.R1.getClass();
        int r102 = (int) c.a.f441291d.toPixels(getContext());
        setPadding(r102, 0, r102, 0);
        setClipToPadding(false);
        setOverScrollMode(2);
        addItemDecoration(new ShareViewLinearDecoration());
        setAdapter(r101);
        setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
    }

    public void setShareItems(List<a> r100) {
        Intrinsics.checkNotNullParameter(r100, "items");
        ((ArrayList) this.f441287a.f441272a).clear();
        ArrayList r101 = (ArrayList) this.f441287a.f441272a;
        r101.addAll(r100);
        this.f441287a.notifyDataSetChanged();
    }

    public SingleLineShareView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        ShareItemAdapter r102 = new ShareItemAdapter();
        this.f441287a = r102;
        c.R1.getClass();
        int r103 = (int) c.a.f441291d.toPixels(getContext());
        setPadding(r103, 0, r103, 0);
        setClipToPadding(false);
        setOverScrollMode(2);
        addItemDecoration(new ShareViewLinearDecoration());
        setAdapter(r102);
        setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
    }

    public SingleLineShareView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        ShareItemAdapter r103 = new ShareItemAdapter();
        this.f441287a = r103;
        c.R1.getClass();
        int r104 = (int) c.a.f441291d.toPixels(getContext());
        setPadding(r104, 0, r104, 0);
        setClipToPadding(false);
        setOverScrollMode(2);
        addItemDecoration(new ShareViewLinearDecoration());
        setAdapter(r103);
        setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
    }
}
