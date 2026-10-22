package com.larus.business.debug.base.adapter.viewHolder;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sv8.d;
import zv8.e;
import zv8.n;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/larus/business/debug/base/adapter/viewHolder/EntranceInputViewHolder;", "Lcom/larus/business/debug/base/adapter/viewHolder/EntranceViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "editor", "Landroid/widget/EditText;", "confirm", "Landroid/widget/Button;", "bind", "", "debugEntrance", "Lcom/larus/business/debug/base/register/DebugEntrance;", "unbind", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EntranceInputViewHolder extends EntranceViewHolder {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f319964d = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public EditText f319965b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Button f319966c;

    public EntranceInputViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
    }

    @Override // com.larus.business.debug.base.adapter.viewHolder.EntranceViewHolder
    public final void T3(final e r100) {
        Intrinsics.checkNotNullParameter(r100, "debugEntrance");
        Intrinsics.checkNotNullParameter(r100, "debugEntrance");
        this.f319977a = r100;
        this.f319965b = (EditText) this.itemView.findViewById(R.id.entrance_input_editor);
        this.f319966c = (Button) this.itemView.findViewById(R.id.entrance_input_confirm);
        if ((r100 instanceof n) == false) goto L5;
        final n r101 = (n) r100;
    L6:
        if (r101 == null) goto L32;
        EditText r102 = this.f319965b;
        boolean r103 = false;
        String r104 = "";
        if (r102 != null) goto L10;
    L17:
        EditText r105 = this.f319965b;
        if (r105 == null) goto L20;
        r105.setText(r101.f());
    L20:
        Button r106 = this.f319966c;
        if (r106 != null) goto L23;
    L28:
        Button r107 = this.f319966c;
        if (r107 == null) goto L33;
        r107.setOnClickListener(new d(r100, r101, this));
        return;
    L33:
        return;
    L23:
        if ("".length() != 0) goto L25;
        r103 = true;
    L25:
        if (r103 == false) goto L27;
        r104 = "确认设置";
    L27:
        r106.setText(r104);
        goto L28
    L10:
        if ("".length() != 0) goto L12;
        boolean r108 = true;
    L13:
        if (r108 == false) goto L15;
        String r109 = r101.c();
    L16:
        r102.setHint(r109);
        goto L17
    L15:
        r109 = "";
        goto L16
    L12:
        r108 = false;
        goto L13
    L32:
        return;
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.larus.business.debug.base.adapter.viewHolder.EntranceViewHolder
    public final void U3(e r100) {
        Intrinsics.checkNotNullParameter(r100, "debugEntrance");
        Intrinsics.checkNotNullParameter(r100, "debugEntrance");
        EditText r101 = this.f319965b;
        if (r101 == null) goto L5;
        r101.setVisibility(0);
    L5:
        Button r102 = this.f319966c;
        if (r102 == null) goto L8;
        r102.setVisibility(0);
    L8:
        EditText r103 = this.f319965b;
        if (r103 == null) goto L11;
        r103.setText("");
    L11:
        EditText r104 = this.f319965b;
        if (r104 == null) goto L14;
        r104.setHint("");
    L14:
        Button r105 = this.f319966c;
        if (r105 == null) goto L18;
        r105.setOnClickListener(null);
        return;
    }
}
