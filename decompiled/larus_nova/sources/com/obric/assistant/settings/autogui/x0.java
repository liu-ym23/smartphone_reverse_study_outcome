package com.obric.assistant.settings.autogui;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import com.obric.oui.text.OTextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class x0 extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OTextView f391976a;

    public x0(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super(r100);
        this.f391976a = (OTextView) r100.findViewById(R.id.obric_section_title);
    }
}
