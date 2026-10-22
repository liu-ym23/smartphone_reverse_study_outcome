package com.larus.business.debug.base.adapter.viewHolder;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zv8.e;
import zv8.k;
import zv8.o;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/larus/business/debug/base/adapter/viewHolder/EntranceSpinnerViewHolder;", "Lcom/larus/business/debug/base/adapter/viewHolder/EntranceViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "spinnerName", "Landroid/widget/TextView;", "spinnerView", "Landroid/widget/Spinner;", "bind", "", "debugEntrance", "Lcom/larus/business/debug/base/register/DebugEntrance;", "unbind", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EntranceSpinnerViewHolder extends EntranceViewHolder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f319967b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Spinner f319968c;

    public static final class a implements AdapterView.OnItemSelectedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f319969a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f319970b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AdapterView.OnItemSelectedListener f319971c;

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public final void onNothingSelected(AdapterView<?> r100) {
            this.f319971c.onNothingSelected(r100);
        }

        public a(e r100, AdapterView.OnItemSelectedListener r101) {
            this.f319970b = r100;
            this.f319971c = r101;
            this.f319969a = true;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public final void onItemSelected(AdapterView<?> r100, View r101, int r110, long r111) {
            if (this.f319969a == false) goto L6;
            this.f319969a = false;
            return;
        L6:
            k.e(this.f319970b);
            this.f319971c.onItemSelected(r100, r101, r110, r111);
        }
    }

    public EntranceSpinnerViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
    }

    @Override // com.larus.business.debug.base.adapter.viewHolder.EntranceViewHolder
    public final void T3(e r100) {
        Intrinsics.checkNotNullParameter(r100, "debugEntrance");
        Intrinsics.checkNotNullParameter(r100, "debugEntrance");
        this.f319977a = r100;
        this.f319967b = (TextView) this.itemView.findViewById(R.id.entrance_spinner_name);
        this.f319968c = (Spinner) this.itemView.findViewById(R.id.entrance_spinner_list);
        if ((r100 instanceof o) == false) goto L5;
        o r101 = (o) r100;
    L6:
        if (r101 == null) goto L20;
        TextView r102 = this.f319967b;
        if (r102 == null) goto L10;
        r102.setText(r101.c());
    L10:
        Spinner r103 = this.f319968c;
        if (r103 == null) goto L13;
        r103.setAdapter(r101.f());
    L13:
        AdapterView.OnItemSelectedListener r104 = r101.h();
        Spinner r105 = this.f319968c;
        if (r105 == null) goto L16;
        r105.setOnItemSelectedListener(new a(r100, r104));
    L16:
        Spinner r106 = this.f319968c;
        if (r106 == null) goto L21;
        r106.setSelection(r101.g());
        return;
    L21:
        return;
    L20:
        return;
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.larus.business.debug.base.adapter.viewHolder.EntranceViewHolder
    public final void U3(e r100) {
        Intrinsics.checkNotNullParameter(r100, "debugEntrance");
        Intrinsics.checkNotNullParameter(r100, "debugEntrance");
        TextView r101 = this.f319967b;
        if (r101 == null) goto L5;
        r101.setVisibility(0);
    L5:
        Spinner r102 = this.f319968c;
        if (r102 == null) goto L8;
        r102.setVisibility(0);
    L8:
        TextView r103 = this.f319967b;
        if (r103 == null) goto L11;
        r103.setText("");
    L11:
        Spinner r104 = this.f319968c;
        if (r104 == null) goto L14;
        r104.setAdapter(null);
    L14:
        Spinner r105 = this.f319968c;
        if (r105 == null) goto L17;
        r105.setOnItemSelectedListener(null);
    L17:
        Spinner r106 = this.f319968c;
        if (r106 == null) goto L21;
        r106.setSelection(0);
        return;
    }
}
