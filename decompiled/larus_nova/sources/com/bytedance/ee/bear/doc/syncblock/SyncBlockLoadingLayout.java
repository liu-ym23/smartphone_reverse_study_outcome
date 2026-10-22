package com.bytedance.ee.bear.doc.syncblock;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.ee.bear.document.loading.LoadingLayout;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\u000bB\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\fB%\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\rJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fJ\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u0006\u0010\u0016\u001a\u00020\u0011J\u0006\u0010\u0017\u001a\u00020\u0011J\u0006\u0010\u0018\u001a\u00020\u0011R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/doc/syncblock/SyncBlockLoadingLayout;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mOnRetryListener", "Lcom/bytedance/ee/bear/document/loading/LoadingLayout$OnRetryListener;", "setOnRetryListener", "", "fail", "errCode", "errMsg", "", "loading", "show", "hide", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SyncBlockLoadingLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LoadingLayout.c f218283a;

    public SyncBlockLoadingLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 0);
    }

    public final void a(int r100) {
        setOnClickListener(null);
        setVisibility(0);
        View r101 = findViewById(R.id.ll_loading);
        if (r101 == null) goto L5;
        r101.setVisibility(8);
    L5:
        SpaceEmptyState r102 = (SpaceEmptyState) findViewById(R.id.facade_no_data_empty_state);
        r102.setVisibility(0);
        if (r100 != 4) goto L8;
        r102.setImageRes(Integer.valueOf(R.drawable.ccm_empty_neutral_no_access));
        StringCompanionObject r103 = StringCompanionObject.INSTANCE;
        r102.setDesc(String.format("%s", Arrays.copyOf(new Object[]{getContext().getResources().getString(R.string.Doc_Permission_OwnerNotAuthorizeCross)}, 1)));
        return;
    L8:
        if (r100 == 1002) goto L10;
        r102.setImageRes(Integer.valueOf(R.drawable.ccm_empty_negative_load_failed));
        StringCompanionObject r104 = StringCompanionObject.INSTANCE;
        r102.setDesc(String.format("%s", Arrays.copyOf(new Object[]{getContext().getResources().getString(R.string.Doc_Facade_LoadFailed)}, 1)));
        setOnClickListener(new d(this, r100));
        return;
    L10:
        r102.setImageRes(Integer.valueOf(R.drawable.ccm_vc_empty_neutral_recycle_bin));
        StringCompanionObject r105 = StringCompanionObject.INSTANCE;
        r102.setDesc(String.format("%s", Arrays.copyOf(new Object[]{getContext().getResources().getString(R.string.LarkCCM_Docs_SyncBlock_Deleted_Toast)}, 1)));
    }

    public final void setOnRetryListener(LoadingLayout.c r100) {
        Intrinsics.checkNotNullParameter(r100, "mOnRetryListener");
        this.f218283a = r100;
    }

    public SyncBlockLoadingLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 0);
    }

    public SyncBlockLoadingLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r102, 0);
    }

    public SyncBlockLoadingLayout(Context r100, AttributeSet r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102, 0);
        FrameLayout.inflate(getContext(), R.layout.doc_empty_layout, this);
    }
}
