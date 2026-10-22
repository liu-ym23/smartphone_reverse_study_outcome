package com.ss.android.lark.keyboard.keyboard2.content;

import android.content.Intent;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes36.dex */
public interface IKeyboardContent {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/keyboard/keyboard2/content/IKeyboardContent$ViewInitStrategy;", "", "<init>", "(Ljava/lang/String;I)V", "Lazy", "Idle", "Immediate", "keyboard-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ViewInitStrategy extends Enum<ViewInitStrategy> {
        public static final ViewInitStrategy Idle = null;
        public static final ViewInitStrategy Immediate = null;
        public static final ViewInitStrategy Lazy = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ViewInitStrategy[] f429504a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f429505b = null;

        public static EnumEntries<ViewInitStrategy> getEntries() {
            return f429505b;
        }

        static {
            ViewInitStrategy r100 = new ViewInitStrategy("Lazy", 0);
            Lazy = r100;
            ViewInitStrategy r101 = new ViewInitStrategy("Idle", 1);
            Idle = r101;
            ViewInitStrategy r102 = new ViewInitStrategy("Immediate", 2);
            Immediate = r102;
            ViewInitStrategy[] r103 = {r100, r101, r102};
            f429504a = r103;
            f429505b = EnumEntriesKt.enumEntries(r103);
        }

        public static ViewInitStrategy[] values() {
            return (ViewInitStrategy[]) f429504a.clone();
        }

        public static ViewInitStrategy valueOf(String r100) {
            return (ViewInitStrategy) r27.a.a(ViewInitStrategy.class, r100);
        }

        public ViewInitStrategy(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface a {
        String getTag();
    }

    ViewInitStrategy a();

    View b(ViewGroup r100);

    void c(int r100);

    a getKey();

    void onActivityResult(int r100, int r101, Intent r102);

    void onConfigurationChanged(Configuration r100);

    void onCreate();

    void onDestroy();

    void onHide();

    void onShow();
}
