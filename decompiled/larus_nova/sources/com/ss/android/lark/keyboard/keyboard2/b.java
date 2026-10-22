package com.ss.android.lark.keyboard.keyboard2;

import android.widget.EditText;
import com.ss.android.lark.keyboard.plugin.input.base.InputSupportType;

/* JADX INFO: loaded from: classes36.dex */
public interface b extends c {
    public static final a K1 = null;

    public static final class a implements c.a<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f429503a = null;

        static {
            f429503a = new a();
        }

        public a() {
        }
    }

    static {
        K1 = a.f429503a;
    }

    EditText c();

    InputSupportType getInputType();

    void setEnable(boolean r100);
}
