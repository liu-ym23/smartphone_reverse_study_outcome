package com.ss.android.lark.todo.impl.features.messagecard.pin;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes38.dex */
public final class b extends iya.b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f443929e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f443930a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewGroup f443931b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f443932c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f443933d;

    public static final class a {
    }

    static {
    }

    public b(View r100) {
        this.f443930a = r100;
        this.f443931b = (ViewGroup) r100.findViewById(R.id.todo_container_layout);
        ImageView r101 = (ImageView) r100.findViewById(R.id.todo_ic);
        this.f443932c = (TextView) r100.findViewById(R.id.tv_title);
        this.f443933d = (TextView) r100.findViewById(R.id.todo_assignee_content);
    }
}
