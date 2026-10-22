package com.bytedance.android.livesdk.livecommerce.oldflash;

import android.view.View;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class i0 extends BaseViewHolder {
    public final View c;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ i0 a;
        public final /* synthetic */ b b;

        public a(i0 r1, b r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            LiveFlashViewModel r3 = this.a.a;
            if (r3 == null) goto L8;
            MutableLiveData<b> r4 = r3.getItemClickObserver();
            if (r4 == null) goto L9;
            r4.postValue(this.b);
            return;
        L9:
            return;
        }
    }

    public i0(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super(r2);
        this.c = r2.findViewById(2131376558);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.oldflash.BaseViewHolder
    public final void T3(b r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "itemData");
        if ((r2 instanceof f) == true) goto L5;
        b r4 = null;
    L6:
        f r5 = (f) r4;
        if (r5 != null) goto L9;
    L12:
        ((RecyclerView.ViewHolder) this).itemView.setOnClickListener(new a(this, r2));
        return;
    L9:
        if (r5.b == false) goto L11;
        this.c.setRotation(180.0f);
        goto L12
    L11:
        this.c.setRotation(0.0f);
        goto L12
    L5:
        r4 = r2;
        goto L6
    }
}
