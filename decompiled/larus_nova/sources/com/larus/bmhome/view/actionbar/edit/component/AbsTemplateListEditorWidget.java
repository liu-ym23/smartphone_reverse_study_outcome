package com.larus.bmhome.view.actionbar.edit.component;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.instruction.base.AbsInstructionWidget;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\r\u001a\u00020\u000eH\u0016J\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0007R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0014\u0010\t\u001a\u0004\u0018\u00010\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/larus/bmhome/view/actionbar/edit/component/AbsTemplateListEditorWidget;", "Lcom/larus/bmhome/instruction/base/AbsInstructionWidget;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "defaultSelectionIndexForScroll", "", "Ljava/lang/Integer;", "templateListView", "Landroidx/recyclerview/widget/RecyclerView;", "getTemplateListView", "()Landroidx/recyclerview/widget/RecyclerView;", "onViewShow", "", "updateDefaultSelectionIndex", "index", "layoutListener", "Landroid/view/View$OnLayoutChangeListener;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsTemplateListEditorWidget extends AbsInstructionWidget {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Integer f316036f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b f316037g;

    public static final class a {
    }

    public static final class b implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbsTemplateListEditorWidget f316038a;

        public b(AbsTemplateListEditorWidget r100) {
            this.f316038a = r100;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
            Integer r109 = this.f316038a.f316036f;
            if (r109 == null) goto L21;
            int r110 = r109.intValue();
            RecyclerView r111 = this.f316038a.getTemplateListView();
            if (r111 == null) goto L9;
            RecyclerView.LayoutManager r112 = r111.getLayoutManager();
            if (r112 == null) goto L9;
            int r113 = r112.getChildCount();
        L10:
            if (r113 <= 0) goto L22;
            if (r110 <= 0) goto L23;
            FLogger.f375446a.i("AbsTemplateListEditorComponent", "onLayoutChange smoothScrollToPosition " + this.f316038a.f316036f);
            RecyclerView r114 = this.f316038a.getTemplateListView();
            if (r114 == null) goto L17;
            RecyclerView.LayoutManager r115 = r114.getLayoutManager();
            if (r115 == null) goto L17;
            r115.scrollToPosition(r110);
        L17:
            AbsTemplateListEditorWidget r116 = this.f316038a;
            r116.f316036f = null;
            RecyclerView r117 = r116.getTemplateListView();
            if (r117 == null) goto L24;
            r117.removeOnLayoutChangeListener(this);
            return;
        L24:
            return;
        L23:
            return;
        L22:
            return;
        L9:
            r113 = 0;
            goto L10
        }
    }

    static {
    }

    public abstract RecyclerView getTemplateListView();

    @Override // com.larus.bmhome.instruction.base.AbsInstructionWidget
    public final void Z5() {
        RecyclerView r100 = getTemplateListView();
        if (r100 == null) goto L6;
        r100.addOnLayoutChangeListener(this.f316037g);
        return;
    }

    public AbsTemplateListEditorWidget(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, null, 6, 0);
        this.f316037g = new b(this);
    }
}
