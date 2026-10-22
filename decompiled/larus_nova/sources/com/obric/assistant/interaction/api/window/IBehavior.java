package com.obric.assistant.interaction.api.window;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\b\u0010\f\u001a\u00020\u0003H\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¨\u0006\u0012"}, d2 = {"Lcom/obric/assistant/interaction/api/window/IBehavior;", "", "init", "", "onWindowShow", "onWindowHide", "onWindowDismiss", "onAppBackground", "onAppForeground", "onWindowPreShow", "onWindowPreloaded", "onWindowPreOpenClear", "onWindowPreHide", "onWindowPreDismiss", "onScreenRotationChanged", "previousRotation", "", "newRotation", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IBehavior {

    /* JADX INFO: loaded from: classes33.dex */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void onAppBackground(IBehavior r100) {
        }

        public static void onAppForeground(IBehavior r100) {
        }

        public static void onScreenRotationChanged(IBehavior r100, int r101, int r102) {
        }

        public static void onWindowDismiss(IBehavior r100) {
        }

        public static void onWindowHide(IBehavior r100) {
        }

        public static void onWindowPreDismiss(IBehavior r100) {
        }

        public static void onWindowPreHide(IBehavior r100) {
        }

        public static void onWindowPreOpenClear(IBehavior r100) {
        }

        public static void onWindowPreShow(IBehavior r100) {
        }

        public static void onWindowPreloaded(IBehavior r100) {
        }

        public static void onWindowShow(IBehavior r100) {
        }
    }

    void init();

    void onAppBackground();

    void onAppForeground();

    void onScreenRotationChanged(int r100, int r101);

    void onWindowDismiss();

    void onWindowHide();

    void onWindowPreDismiss();

    void onWindowPreHide();

    void onWindowPreOpenClear();

    void onWindowPreShow();

    void onWindowPreloaded();

    void onWindowShow();
}
