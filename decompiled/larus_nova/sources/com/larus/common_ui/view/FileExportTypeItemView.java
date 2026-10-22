package com.larus.common_ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.larus.common_ui.widget.roundlayout.RoundConstraintLayout;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000fJ\u0010\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0019"}, d2 = {"Lcom/larus/common_ui/view/FileExportTypeItemView;", "Lcom/larus/common_ui/widget/roundlayout/RoundConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "fileTypeIcon", "Landroid/widget/ImageView;", "fileTypeName", "Landroid/widget/TextView;", "value", "Lcom/larus/common_ui/view/FileExportType;", "fileType", "getFileType", "()Lcom/larus/common_ui/view/FileExportType;", "setItemType", "", "type", "setSelected", "selected", "", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FileExportTypeItemView extends RoundConstraintLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f328236c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f328237d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public FileExportType f328238e;

    public FileExportTypeItemView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public FileExportTypeItemView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final FileExportType getFileType() {
        return this.f328238e;
    }

    public final void setItemType(FileExportType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.f328237d.setText(getContext().getString(r100.nameRes()));
        this.f328236c.setImageResource(r100.iconRes());
        this.f328238e = r100;
    }

    @Override // android.view.View
    public void setSelected(boolean r100) {
        super.setSelected(r100);
        Context r101 = null;
        if (r100 == false) goto L9;
        ImageView r102 = this.f328236c;
        if (r102 == null) goto L7;
        Context r103 = r102.getContext();
    L8:
        int r104 = v19.c.b(R.attr.larus_primary_transparent_1, r103, R.color.larus_primary_transparent_1);
    L14:
        if (r100 == false) goto L19;
        ImageView r105 = this.f328236c;
        if (r105 == null) goto L18;
        r101 = r105.getContext();
    L18:
        int r106 = v19.c.b(R.attr.larus_primary_50, r101, R.color.larus_primary_50);
    L20:
        getDelegate().a(ContextCompat.getColor(getContext(), r104));
        getDelegate().g(ContextCompat.getColor(getContext(), r106));
        return;
    L19:
        r106 = android.R.color.transparent;
        goto L20
    L7:
        r103 = null;
        goto L8
    L9:
        ImageView r107 = this.f328236c;
        if (r107 == null) goto L12;
        Context r108 = r107.getContext();
    L13:
        r104 = v19.c.b(R.attr.larus_base_4_overlay, r108, R.color.larus_base_4_overlay);
        goto L14
    L12:
        r108 = null;
        goto L13
    }

    public FileExportTypeItemView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f328238e = FileExportType.word;
        View r103 = LayoutInflater.from(r100).inflate(R.layout.larus_layout_file_export_type_item, this);
        this.f328236c = (ImageView) r103.findViewById(R.id.fileTypeIcon);
        this.f328237d = (TextView) r103.findViewById(R.id.fileTypeName);
        getDelegate().d(12);
        c29.a r104 = getDelegate();
        Resources r105 = r104.f22220b.getResources();
        r104.f22231m = (int) ((1 * WindowDisplayMetricsOverride.apply(r105, r105.getDisplayMetrics()).density) + 0.5f);
        r104.c();
        setSelected(false);
    }

    public /* synthetic */ FileExportTypeItemView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
