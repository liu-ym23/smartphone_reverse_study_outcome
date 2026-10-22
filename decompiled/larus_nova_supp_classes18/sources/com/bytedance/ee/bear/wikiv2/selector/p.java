package com.bytedance.ee.bear.wikiv2.selector;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.t0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class p extends LinearLayout {
    public final FolderSelectAdapter a;
    public n.a b;

    public static final class a implements FolderSelectAdapter.a {
        public final /* synthetic */ p a;

        public a(p r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.wikiv2.selector.FolderSelectAdapter.a
        public final void a(View r11, int r12, Document r13) {
            Intrinsics.checkNotNullParameter(r13, "item");
            n.a r0 = this.a.b;
            if (r0 == null) goto L10;
            int r2 = r13.getType();
            String r3 = r13.d;
            if (r11 == null) goto L7;
            Context r1 = r11.getContext();
        L8:
            String r4 = t0.g(r1, r13);
            FolderVersion.a r5 = FolderVersion.Companion;
            int r6 = r13.L1;
            boolean r7 = r13.P1;
            r5.getClass();
            r0.a6(r11, r12, new td5.e(r2, r3, r4, FolderVersion.a.b(r6, r7), FolderSource.SEARCH.getSource(), r13.L1, r13.x));
            return;
        L7:
            r1 = null;
            goto L8
        }
    }

    public p(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5);
        View.inflate(r5, 2131568249, this);
        RecyclerView r0 = findViewById(2131393257);
        r0.setLayoutManager(new LinearLayoutManager(r5));
        AccountService.Account r1 = ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2();
        Intrinsics.checkNotNull(r1);
        FolderSelectAdapter r2 = new FolderSelectAdapter(r5, r1);
        this.a = r2;
        r2.d = new a(this);
        r0.setAdapter(r2);
    }

    public final void setViewDelegate(n.a r1) {
        this.b = r1;
    }
}
