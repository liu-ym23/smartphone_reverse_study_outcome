package com.ss.android.lark.chameleon.pluginsystem.plugin;

/* JADX INFO: loaded from: classes35.dex */
public class TransactionParams {
    public boolean addToBackStack;
    public int enterAnimation;
    public int exitAnimation;
    public int popEnterAnimation;
    public int popExitAnimation;

    public TransactionParams() {
    }

    public TransactionParams addToBackStack() {
        this.addToBackStack = true;
        return this;
    }

    public TransactionParams setEnterAnimation(int r100) {
        this.enterAnimation = r100;
        return this;
    }

    public TransactionParams setExitAnimation(int r100) {
        this.exitAnimation = r100;
        return this;
    }

    public TransactionParams setPopEnterAnimation(int r100) {
        this.popEnterAnimation = r100;
        return this;
    }

    public TransactionParams setPopExitAnimation(int r100) {
        this.popExitAnimation = r100;
        return this;
    }

    public static TransactionParams ofAnimation(int r100, int r101) {
        return ofAnimation(r100, r101, 0, 0);
    }

    public static TransactionParams ofAnimation(int r100, int r101, int r102, int r103) {
        TransactionParams r104 = new TransactionParams();
        r104.enterAnimation = r100;
        r104.exitAnimation = r101;
        r104.popEnterAnimation = r102;
        r104.popExitAnimation = r103;
        return r104;
    }
}
