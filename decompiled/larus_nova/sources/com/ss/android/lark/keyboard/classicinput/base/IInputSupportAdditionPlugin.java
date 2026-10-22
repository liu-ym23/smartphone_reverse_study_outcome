package com.ss.android.lark.keyboard.classicinput.base;

import android.view.View;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: classes36.dex */
public interface IInputSupportAdditionPlugin {

    public interface OnPanelChangeListener {

        @Target({ElementType.TYPE, ElementType.TYPE_USE})
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/keyboard/classicinput/base/IInputSupportAdditionPlugin$OnPanelChangeListener$State;", "", "Companion", "keyboard-biz-textinput_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.TYPE})
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        public @interface State {
            public static final int COLLAPSE = 1;
            public static final a Companion = null;
            public static final int EXPAND = 0;

            public static final class a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ a f428673a = null;

                static {
                    f428673a = new a();
                }

                public a() {
                }
            }

            static {
                Companion = a.f428673a;
            }
        }

        void a();

        void b();

        void c();
    }

    public interface a {
    }

    View a();

    void b();

    void c();

    View d();

    int getLayoutId();

    void onDestroy();

    void onStop();
}
