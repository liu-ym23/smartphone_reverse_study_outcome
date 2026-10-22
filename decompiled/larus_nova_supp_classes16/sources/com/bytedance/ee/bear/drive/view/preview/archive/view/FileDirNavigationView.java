package com.bytedance.ee.bear.drive.view.preview.archive.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.util.ui.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class FileDirNavigationView extends RecyclerView {
    public final a a;
    public final List<FileTreeRvView.a> b;
    public b c;

    public class a extends RecyclerView.Adapter<C0173a> {
        public final /* synthetic */ FileDirNavigationView a;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.view.preview.archive.view.FileDirNavigationView$a$a, reason: collision with other inner class name */
        public class C0173a extends RecyclerView.ViewHolder {
            public final TextView a;
            public final ImageView b;

            public C0173a(View r2) {
                super(r2);
                this.a = (TextView) r2.findViewById(2131390506);
                this.b = (ImageView) r2.findViewById(2131375024);
            }
        }

        public final int getItemCount() {
            return this.a.b.size();
        }

        public a(FileDirNavigationView r1) {
            this.a = r1;
        }

        public final void onBindViewHolder(RecyclerView.ViewHolder r6, int r7) {
            C0173a r8 = (C0173a) r6;
            FileTreeRvView.a r0 = (FileTreeRvView.a) ListProtector.get(this.a.b, r7);
            ((RecyclerView.ViewHolder) r8).itemView.setOnClickListener(new com.bytedance.ee.bear.drive.view.preview.archive.view.a(this, r0));
            String r1 = r0.b.a;
            TextView r2 = r8.a;
            if (r1 != null) goto L6;
            r1 = "";
        L6:
            r2.setText(r1);
            if (r7 != (((ArrayList) this.a.b).size() - 1)) goto L9;
            r8.a.setTextColor(this.a.getResources().getColor(2131106607));
            r8.b.setVisibility(8);
            ((RecyclerView.ViewHolder) r8).itemView.setClickable(false);
        L11:
            if (r7 != 0) goto L14;
            r8.a.setPadding(n.d(16), 0, 0, 0);
            return;
        L14:
            if (r7 != (((ArrayList) this.a.b).size() - 1)) goto L16;
            r8.a.setPadding(0, 0, n.d(16), 0);
            return;
        L16:
            r8.a.setPadding(0, 0, 0, 0);
            return;
        L9:
            r8.a.setTextColor(this.a.getResources().getColor(2131105548));
            r8.b.setVisibility(0);
            ((RecyclerView.ViewHolder) r8).itemView.setClickable(true);
            goto L11
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
            return new C0173a(LayoutInflater.from(r3.getContext()).inflate(2131560195, r3, false));
        }
    }

    public interface b {
    }

    public List<FileTreeRvView.a> getDirDataModels() {
        return this.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FileDirNavigationView(Context r4) {
        super(r4);
        a r5 = new a(this);
        this.a = r5;
        LinearLayoutManager r0 = new LinearLayoutManager(getContext(), 0, false);
        this.b = new ArrayList();
        setLayoutManager(r0);
        setAdapter(r5);
    }

    public void setNavigationItemClickListener(b r1) {
        this.c = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FileDirNavigationView(Context r3, AttributeSet r4) {
        super(r3, r4);
        a r5 = new a(this);
        this.a = r5;
        LinearLayoutManager r6 = new LinearLayoutManager(getContext(), 0, false);
        this.b = new ArrayList();
        setLayoutManager(r6);
        setAdapter(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FileDirNavigationView(Context r2, AttributeSet r3, int r4) {
        super(r2, r3, r4);
        a r5 = new a(this);
        this.a = r5;
        LinearLayoutManager r6 = new LinearLayoutManager(getContext(), 0, false);
        this.b = new ArrayList();
        setLayoutManager(r6);
        setAdapter(r5);
    }
}
