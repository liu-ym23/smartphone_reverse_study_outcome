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
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public class FileDirNavigationView extends RecyclerView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f224710a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<FileTreeRvView.a> f224711b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f224712c;

    public class a extends RecyclerView.Adapter<C3229a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FileDirNavigationView f224713a;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.view.preview.archive.view.FileDirNavigationView$a$a, reason: collision with other inner class name */
        public class C3229a extends RecyclerView.ViewHolder {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final TextView f224714a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final ImageView f224715b;

            public C3229a(View r100) {
                super(r100);
                this.f224714a = (TextView) r100.findViewById(R.id.tv_dir_name);
                this.f224715b = (ImageView) r100.findViewById(R.id.image_next);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            return this.f224713a.f224711b.size();
        }

        public a(FileDirNavigationView r100) {
            this.f224713a = r100;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
            C3229a r102 = (C3229a) r100;
            FileTreeRvView.a r103 = (FileTreeRvView.a) ListProtector.get(this.f224713a.f224711b, r101);
            r102.itemView.setOnClickListener(new com.bytedance.ee.bear.drive.view.preview.archive.view.a(this, r103));
            String r104 = r103.f224739b.f475965a;
            TextView r105 = r102.f224714a;
            if (r104 != null) goto L6;
            r104 = "";
        L6:
            r105.setText(r104);
            if (r101 != (((ArrayList) this.f224713a.f224711b).size() - 1)) goto L9;
            r102.f224714a.setTextColor(this.f224713a.getResources().getColor(R.color.text_caption));
            r102.f224715b.setVisibility(8);
            r102.itemView.setClickable(false);
        L11:
            if (r101 != 0) goto L14;
            r102.f224714a.setPadding(n.d(16), 0, 0, 0);
            return;
        L14:
            if (r101 != (((ArrayList) this.f224713a.f224711b).size() - 1)) goto L16;
            r102.f224714a.setPadding(0, 0, n.d(16), 0);
            return;
        L16:
            r102.f224714a.setPadding(0, 0, 0, 0);
            return;
        L9:
            r102.f224714a.setTextColor(this.f224713a.getResources().getColor(R.color.primary_fill_default));
            r102.f224715b.setVisibility(0);
            r102.itemView.setClickable(true);
            goto L11
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
            return new C3229a(LayoutInflater.from(r100.getContext()).inflate(R.layout.drive_filetreervview_item_nav, r100, false));
        }
    }

    public interface b {
    }

    public List<FileTreeRvView.a> getDirDataModels() {
        return this.f224711b;
    }

    public FileDirNavigationView(Context r100) {
        super(r100);
        a r101 = new a(this);
        this.f224710a = r101;
        RecyclerView.LayoutManager r102 = new LinearLayoutManager(getContext(), 0, false);
        this.f224711b = new ArrayList();
        setLayoutManager(r102);
        setAdapter(r101);
    }

    public void setNavigationItemClickListener(b r100) {
        this.f224712c = r100;
    }

    public FileDirNavigationView(Context r100, AttributeSet r101) {
        super(r100, r101);
        a r102 = new a(this);
        this.f224710a = r102;
        RecyclerView.LayoutManager r103 = new LinearLayoutManager(getContext(), 0, false);
        this.f224711b = new ArrayList();
        setLayoutManager(r103);
        setAdapter(r102);
    }

    public FileDirNavigationView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        a r103 = new a(this);
        this.f224710a = r103;
        RecyclerView.LayoutManager r104 = new LinearLayoutManager(getContext(), 0, false);
        this.f224711b = new ArrayList();
        setLayoutManager(r104);
        setAdapter(r103);
    }
}
