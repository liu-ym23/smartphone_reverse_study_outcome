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
import f95.e;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class FileNodeContentView extends RecyclerView {
    public final a a;
    public final LinearLayoutManager b;
    public final List<FileTreeRvView.a> c;
    public b d;

    public class a extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        public final /* synthetic */ FileNodeContentView a;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.view.preview.archive.view.FileNodeContentView$a$a, reason: collision with other inner class name */
        public class ViewOnClickListenerC0174a implements View.OnClickListener {
            public final /* synthetic */ FileTreeRvView.a a;
            public final /* synthetic */ RecyclerView.ViewHolder b;
            public final /* synthetic */ a c;

            @Override // android.view.View.OnClickListener
            public final void onClick(View r9) {
                b r10 = this.c.a.d;
                if (r10 == null) goto L12;
                FileTreeRvView.a r0 = this.a;
                View r6 = this.b.itemView;
                FileTreeRvView r11 = (FileTreeRvView) r10;
                f95.a r2 = r11.g;
                if (r2 == null) goto L9;
                if (r2.onContentItemClick(r0.a, r0.b, r0.c, r6, r11.i) == false) goto L9;
                return;
            L9:
                if (r0.c == false) goto L14;
                e r1 = r11.f.a;
                r1.b = r11.b.getCurrentDistanceY();
                r11.c(r11.a.getDirDataModels(), r0);
                return;
            L14:
                return;
            }

            public ViewOnClickListenerC0174a(a r1, FileTreeRvView.a r2, RecyclerView.ViewHolder r3) {
                this.c = r1;
                this.a = r2;
                this.b = r3;
            }
        }

        public class b extends RecyclerView.ViewHolder {
            public final ImageView a;
            public final TextView b;

            public b(View r2) {
                super(r2);
                this.a = (ImageView) r2.findViewById(2131380647);
                this.b = (TextView) r2.findViewById(2131380648);
            }
        }

        public class c extends RecyclerView.ViewHolder {
            public final ImageView a;
            public final TextView b;
            public final TextView c;

            public c(View r2) {
                super(r2);
                this.a = (ImageView) r2.findViewById(2131380647);
                this.b = (TextView) r2.findViewById(2131380648);
                this.c = (TextView) r2.findViewById(2131380649);
            }
        }

        public final int getItemCount() {
            return this.a.c.size();
        }

        public a(FileNodeContentView r1) {
            this.a = r1;
        }

        public final int getItemViewType(int r2) {
            return !((FileTreeRvView.a) ListProtector.get(this.a.c, r2)).c ? 1 : 0;
        }

        public final void onBindViewHolder(RecyclerView.ViewHolder r5, int r6) {
            FileTreeRvView.a r7 = (FileTreeRvView.a) ListProtector.get(this.a.c, r6);
            r5.itemView.setOnClickListener(new ViewOnClickListenerC0174a(this, r7, r5));
            if ((r5 instanceof b) == false) goto L8;
            b r8 = (b) r5;
            r8.b.setText(r7.b.a);
            int r9 = r7.b.b;
            if (r9 == (-1)) goto L17;
            r8.a.setImageResource(kac.a.b(r9));
            return;
        L17:
            return;
        L8:
            if ((r5 instanceof c) == false) goto L19;
            c r10 = (c) r5;
            String r0 = r7.b.a;
            TextView r2 = r10.b;
            if (r0 != null) goto L13;
            r0 = "";
        L13:
            r2.setText(r0);
            r10.c.setText(com.bytedance.ee.util.io.a.e(r7.b.c));
            int r11 = r7.b.b;
            if (r11 == (-1)) goto L20;
            r10.a.setImageResource(kac.a.b(r11));
            return;
        L20:
            return;
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
            LayoutInflater r0 = LayoutInflater.from(r4.getContext());
            if (r5 != 0) goto L7;
            return new b(r0.inflate(2131560193, r4, false));
        L7:
            return new c(r0.inflate(2131560194, r4, false));
        }
    }

    public interface b {
    }

    public int getCurrentDistanceY() {
        int r0 = this.b.findFirstVisibleItemPosition();
        View r1 = this.b.findViewByPosition(r0);
        return (r0 * r1.getHeight()) - r1.getTop();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FileNodeContentView(Context r3) {
        super(r3);
        a r4 = new a(this);
        this.a = r4;
        LinearLayoutManager r0 = new LinearLayoutManager(getContext());
        this.b = r0;
        this.c = new ArrayList();
        setLayoutManager(r0);
        setAdapter(r4);
    }

    public void setContentItemClickListener(b r1) {
        this.d = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FileNodeContentView(Context r2, AttributeSet r3) {
        super(r2, r3);
        a r4 = new a(this);
        this.a = r4;
        LinearLayoutManager r5 = new LinearLayoutManager(getContext());
        this.b = r5;
        this.c = new ArrayList();
        setLayoutManager(r5);
        setAdapter(r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FileNodeContentView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        a r4 = new a(this);
        this.a = r4;
        LinearLayoutManager r5 = new LinearLayoutManager(getContext());
        this.b = r5;
        this.c = new ArrayList();
        setLayoutManager(r5);
        setAdapter(r4);
    }
}
