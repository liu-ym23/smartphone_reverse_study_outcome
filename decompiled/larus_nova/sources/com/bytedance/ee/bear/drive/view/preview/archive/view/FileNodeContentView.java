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
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import f95.e;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public class FileNodeContentView extends RecyclerView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f224716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayoutManager f224717b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<FileTreeRvView.a> f224718c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f224719d;

    public class a extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FileNodeContentView f224720a;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.view.preview.archive.view.FileNodeContentView$a$a, reason: collision with other inner class name */
        public class ViewOnClickListenerC3230a implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ FileTreeRvView.a f224721a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ RecyclerView.ViewHolder f224722b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ a f224723c;

            @Override // android.view.View.OnClickListener
            public final void onClick(View r100) {
                b r101 = this.f224723c.f224720a.f224719d;
                if (r101 == null) goto L12;
                FileTreeRvView.a r102 = this.f224721a;
                View r103 = this.f224722b.itemView;
                FileTreeRvView r104 = (FileTreeRvView) r101;
                f95.a r105 = r104.f224735g;
                if (r105 == null) goto L9;
                if (r105.onContentItemClick(r102.f224738a, r102.f224739b, r102.f224740c, r103, r104.f224737i) == false) goto L9;
                return;
            L9:
                if (r102.f224740c == false) goto L14;
                e r106 = r104.f224734f.f224738a;
                r106.f475970b = r104.f224730b.getCurrentDistanceY();
                r104.c(r104.f224729a.getDirDataModels(), r102);
                return;
            L14:
                return;
            }

            public ViewOnClickListenerC3230a(a r100, FileTreeRvView.a r101, RecyclerView.ViewHolder r102) {
                this.f224723c = r100;
                this.f224721a = r101;
                this.f224722b = r102;
            }
        }

        public class b extends RecyclerView.ViewHolder {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final ImageView f224724a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final TextView f224725b;

            public b(View r100) {
                super(r100);
                this.f224724a = (ImageView) r100.findViewById(R.id.navigation_view_item_icon);
                this.f224725b = (TextView) r100.findViewById(R.id.navigation_view_item_name);
            }
        }

        public class c extends RecyclerView.ViewHolder {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final ImageView f224726a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final TextView f224727b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final TextView f224728c;

            public c(View r100) {
                super(r100);
                this.f224726a = (ImageView) r100.findViewById(R.id.navigation_view_item_icon);
                this.f224727b = (TextView) r100.findViewById(R.id.navigation_view_item_name);
                this.f224728c = (TextView) r100.findViewById(R.id.navigation_view_item_size);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            return this.f224720a.f224718c.size();
        }

        public a(FileNodeContentView r100) {
            this.f224720a = r100;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemViewType(int r100) {
            return !((FileTreeRvView.a) ListProtector.get(this.f224720a.f224718c, r100)).f224740c ? 1 : 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
            FileTreeRvView.a r102 = (FileTreeRvView.a) ListProtector.get(this.f224720a.f224718c, r101);
            r100.itemView.setOnClickListener(new ViewOnClickListenerC3230a(this, r102, r100));
            if ((r100 instanceof b) == false) goto L8;
            b r103 = (b) r100;
            r103.f224725b.setText(r102.f224739b.f475965a);
            int r104 = r102.f224739b.f475966b;
            if (r104 == (-1)) goto L17;
            r103.f224724a.setImageResource(kac.a.b(r104));
            return;
        L17:
            return;
        L8:
            if ((r100 instanceof c) == false) goto L19;
            c r105 = (c) r100;
            String r106 = r102.f224739b.f475965a;
            TextView r107 = r105.f224727b;
            if (r106 != null) goto L13;
            r106 = "";
        L13:
            r107.setText(r106);
            r105.f224728c.setText(com.bytedance.ee.util.io.a.e(r102.f224739b.f475967c));
            int r108 = r102.f224739b.f475966b;
            if (r108 == (-1)) goto L20;
            r105.f224726a.setImageResource(kac.a.b(r108));
            return;
        L20:
            return;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
            LayoutInflater r102 = LayoutInflater.from(r100.getContext());
            if (r101 != 0) goto L7;
            return new b(r102.inflate(R.layout.drive_filetreervview_item_dir, r100, false));
        L7:
            return new c(r102.inflate(R.layout.drive_filetreervview_item_file, r100, false));
        }
    }

    public interface b {
    }

    public int getCurrentDistanceY() {
        int r100 = this.f224717b.findFirstVisibleItemPosition();
        View r101 = this.f224717b.findViewByPosition(r100);
        return (r100 * r101.getHeight()) - r101.getTop();
    }

    public FileNodeContentView(Context r100) {
        super(r100);
        a r101 = new a(this);
        this.f224716a = r101;
        LinearLayoutManager r102 = new LinearLayoutManager(getContext());
        this.f224717b = r102;
        this.f224718c = new ArrayList();
        setLayoutManager(r102);
        setAdapter(r101);
    }

    public void setContentItemClickListener(b r100) {
        this.f224719d = r100;
    }

    public FileNodeContentView(Context r100, AttributeSet r101) {
        super(r100, r101);
        a r102 = new a(this);
        this.f224716a = r102;
        LinearLayoutManager r103 = new LinearLayoutManager(getContext());
        this.f224717b = r103;
        this.f224718c = new ArrayList();
        setLayoutManager(r103);
        setAdapter(r102);
    }

    public FileNodeContentView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        a r103 = new a(this);
        this.f224716a = r103;
        LinearLayoutManager r104 = new LinearLayoutManager(getContext());
        this.f224717b = r104;
        this.f224718c = new ArrayList();
        setLayoutManager(r104);
        setAdapter(r103);
    }
}
