package com.obric.oui.dialog.alert.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.nova.R;
import com.obric.oui.text.OTextView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pla.d;

/* JADX INFO: loaded from: classes34.dex */
@Deprecated(message = "已废弃")
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\n"}, d2 = {"Lcom/obric/oui/dialog/alert/view/DialogMultiTextView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/obric/oui/text/OTextView;", "getContentTextView", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class DialogMultiTextView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OTextView f400623a;

    public final OTextView getContentTextView() {
        return this.f400623a;
    }

    public DialogMultiTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public DialogMultiTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        ViewGroup.inflate(r100, R.layout.o_layout_dialog_multi_text, this);
        OTextView r102 = (OTextView) findViewById(R.id.tv_content);
        this.f400623a = r102;
        r102.setLineHeight(d.n(this, 20));
    }
}
