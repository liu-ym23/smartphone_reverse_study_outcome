package com.ss.android.lark.search.widget.calendar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0016\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014R\u001a\u0010\b\u001a\u00020\tX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/search/widget/calendar/AddPhoneView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mAddPhoneContainer", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getMAddPhoneContainer", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setMAddPhoneContainer", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "initView", "", "updateText", "phoneLength", "", "phoneText", "", "search-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AddPhoneView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ConstraintLayout f440373a;

    public final ConstraintLayout getMAddPhoneContainer() {
        ConstraintLayout r100 = this.f440373a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mAddPhoneContainer");
        return null;
    }

    public AddPhoneView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void setMAddPhoneContainer(ConstraintLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f440373a = r100;
    }

    public AddPhoneView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        LayoutInflater.from(r100).inflate(R.layout.calendar_add_phone, this, true);
        setMAddPhoneContainer((ConstraintLayout) findViewById(R.id.phone_container));
    }
}
