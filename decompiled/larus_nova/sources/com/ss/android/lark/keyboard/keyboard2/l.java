package com.ss.android.lark.keyboard.keyboard2;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larus.nova.R;
import com.ss.android.lark.keyboard.plugin.input.base.InputSupportType;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class l implements mob.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f429562a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final EditText f429563b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.ss.android.lark.keyboard.b f429564c;

    public static final class a implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f429565a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        public a(View r100) {
            this.f429565a = r100;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r100) {
            View r101 = this.f429565a;
            if (r100 != null) goto L5;
        L8:
            boolean r102 = true;
        L9:
            r101.setEnabled(!r102);
            return;
        L5:
            if (r100.length() == 0) goto L8;
            r102 = false;
            goto L9
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f429566a;

        public b(l r100) {
            this.f429566a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f429566a.getClass();
        }
    }

    @Override // mob.a
    public final void A() {
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.c
    public final void d() {
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.c
    public final void j() {
    }

    @Override // mob.a
    public final View onViewCreated(View r100) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        return r100;
    }

    @Override // mob.a
    public final void s(lob.a r100) {
        Intrinsics.checkNotNullParameter(r100, "watcher");
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.b
    public final void setEnable(boolean r100) {
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.b
    public final EditText c() {
        return this.f429563b;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.b
    public final InputSupportType getInputType() {
        return InputSupportType.Text;
    }

    public l(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        View r101 = LayoutInflater.from(r100).inflate(R.layout.kb_default_editor, null);
        r101.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.f429562a = r101;
        this.f429563b = (EditText) r101.findViewById(R.id.content_editor);
    }

    @Override // mob.a
    public final View b(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        return this.f429562a;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.c
    public final void setKeyboard(com.ss.android.lark.keyboard.b r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f429564c = r100;
    }

    @Override // mob.a
    public final View t(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        View r101 = com.ss.android.lark.keyboard.utils.h.b(r100.getContext());
        r101.setOnClickListener(new b(this));
        this.f429563b.addTextChangedListener(new a(r101));
        Intrinsics.checkNotNull(r101);
        return r101;
    }
}
