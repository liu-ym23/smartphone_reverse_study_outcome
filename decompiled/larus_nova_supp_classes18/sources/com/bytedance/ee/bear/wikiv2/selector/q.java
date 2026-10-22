package com.bytedance.ee.bear.wikiv2.selector;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class q extends LinearLayout {
    public final RecentOperationAdapter a;
    public n.a b;
    public ce5.a c;

    public static final class a implements RecentOperationAdapter.b {
        public final /* synthetic */ q a;

        public a(q r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.wikiv2.selector.RecentOperationAdapter.b
        public final void a(View r11, int r12, RecentOperationResult.FolderInfo r13) {
            Intrinsics.checkNotNullParameter(r13, DocumentType.FOLDER_NAME);
            n.a r0 = this.a.b;
            if (r0 == null) goto L10;
            int r2 = r13.getType();
            String r3 = r13.getObjToken();
            if (r11 == null) goto L7;
            Context r1 = r11.getContext();
        L8:
            String r4 = r13.title(r1);
            FolderVersion.a r5 = FolderVersion.Companion;
            int r6 = r13.getOwnerType();
            boolean r7 = r13.isShareFolder();
            r5.getClass();
            r0.a6(r11, r12, new td5.e(r2, r3, r4, FolderVersion.a.b(r6, r7), FolderSource.SEARCH.getSource(), r13.getOwnerType(), r13.isExternal()));
            return;
        L7:
            r1 = null;
            goto L8
        }

        @Override // com.bytedance.ee.bear.wikiv2.selector.RecentOperationAdapter.b
        public final void b(View r10, int r11, RecentOperationResult.WikiInfo r12) {
            Intrinsics.checkNotNullParameter(r12, DocumentType.WIKI_NAME);
            n.a r0 = this.a.b;
            if (r0 == null) goto L10;
            String r4 = r12.getWikiToken();
            if (r10 == null) goto L7;
            Context r1 = r10.getContext();
        L8:
            r0.J2(new iq5.o(r10, r11, r4, r12.title(r1), r12.getSpaceId(), r12.spaceName()));
            return;
        L7:
            r1 = null;
            goto L8
        }
    }

    public q(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4);
        View.inflate(r4, 2131568250, this);
        RecyclerView r0 = findViewById(2131393258);
        r0.setLayoutManager(new LinearLayoutManager(r4));
        RecentOperationAdapter r1 = new RecentOperationAdapter(r4);
        this.a = r1;
        r1.e = this.c;
        a r5 = new a(this);
        Intrinsics.checkNotNullParameter(r5, "listener");
        r1.c = r5;
        r0.setAdapter(r1);
    }

    public final void setUserComponentAbility(ce5.a r1) {
        this.c = this.c;
    }

    public final void setViewDelegate(n.a r1) {
        this.b = r1;
    }
}
