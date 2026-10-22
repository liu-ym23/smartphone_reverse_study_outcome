package com.ss.android.lark.keyboard.keyboard2;

import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes36.dex */
public abstract class PanelMenuItem extends o {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InitialStrategy f429498c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/keyboard/keyboard2/PanelMenuItem$InitialStrategy;", "", "<init>", "(Ljava/lang/String;I)V", "Lazy", "Idle", "Immediate", "keyboard-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum InitialStrategy extends Enum<InitialStrategy> {
        public static final InitialStrategy Idle = null;
        public static final InitialStrategy Immediate = null;
        public static final InitialStrategy Lazy = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ InitialStrategy[] f429499a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f429500b = null;

        public static EnumEntries<InitialStrategy> getEntries() {
            return f429500b;
        }

        static {
            InitialStrategy r100 = new InitialStrategy("Lazy", 0);
            Lazy = r100;
            InitialStrategy r101 = new InitialStrategy("Idle", 1);
            Idle = r101;
            InitialStrategy r102 = new InitialStrategy("Immediate", 2);
            Immediate = r102;
            InitialStrategy[] r103 = {r100, r101, r102};
            f429499a = r103;
            f429500b = EnumEntriesKt.enumEntries(r103);
        }

        public static InitialStrategy[] values() {
            return (InitialStrategy[]) f429499a.clone();
        }

        public static InitialStrategy valueOf(String r100) {
            return (InitialStrategy) r27.a.a(InitialStrategy.class, r100);
        }

        public InitialStrategy(String r100, int r101) {
            super(r100, r101);
        }
    }

    public abstract View G(ViewGroup r100);

    public PanelMenuItem() {
        this.f429498c = InitialStrategy.Lazy;
    }

    public InitialStrategy C() {
        return this.f429498c;
    }
}
