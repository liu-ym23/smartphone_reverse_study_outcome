package com.ss.android.lark.todo.impl.features.setting.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import com.larksuite.component.universe_design.udswitch.UDSwitch;

/* JADX INFO: loaded from: classes38.dex */
public class TodoSwitchView extends UDSwitch {
    public a B;

    public class a implements CompoundButton.OnCheckedChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f444004a;

        public a(TodoSwitchView r100, b r101) {
            this.f444004a = r101;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton r100, boolean r101) {
            b r102 = this.f444004a;
            if (r102 == null) goto L8;
            if (r101 == false) goto L6;
            r102.b();
            return;
        L6:
            r102.a();
            return;
        }
    }

    public interface b {
        void a();

        void b();
    }

    public TodoSwitchView(Context r100) {
        super(r100);
    }

    public void setCheckedNoEvent(boolean r100) {
        if (this.B != null) goto L5;
        setChecked(r100);
        return;
    L5:
        super.setOnCheckedChangeListener(null);
        setChecked(r100);
        super.setOnCheckedChangeListener(this.B);
    }

    public void setOnStateChangedListener(b r100) {
        a r101 = new a(this, r100);
        this.B = r101;
        setOnCheckedChangeListener(r101);
    }

    public TodoSwitchView(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public TodoSwitchView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
