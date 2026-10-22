package com.ss.android.lark.todo.impl.features.detail.sections;

import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.widget.EllipsizeFrameLayout;

/* JADX INFO: loaded from: classes38.dex */
public final class w implements EllipsizeFrameLayout.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ EllipsizeFrameLayout f443458a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DetailCustomFieldsAdapter.CustomFieldViewHolder f443459b;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DetailCustomFieldsAdapter.CustomFieldViewHolder f443460a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f443461b;

        public a(DetailCustomFieldsAdapter.CustomFieldViewHolder r100, boolean r101) {
            this.f443460a = r100;
            this.f443461b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.larksuite.framework.section.utils.a.d(this.f443460a.itemView.findViewById(R.id.text_field_value_gradient_mask), this.f443461b);     // Catch: Throwable -> L4
            com.larksuite.framework.section.utils.a.d(this.f443460a.itemView.findViewById(R.id.text_field_value_more), this.f443461b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public w(EllipsizeFrameLayout r100, DetailCustomFieldsAdapter.CustomFieldViewHolder r101) {
        this.f443458a = r100;
        this.f443459b = r101;
    }

    @Override // com.ss.android.lark.widget.EllipsizeFrameLayout.b
    public final void a(boolean r100) {
        this.f443458a.post(new a(this.f443459b, r100));
    }
}
