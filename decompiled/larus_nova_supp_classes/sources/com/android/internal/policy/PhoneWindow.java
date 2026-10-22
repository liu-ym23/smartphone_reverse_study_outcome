package com.android.internal.policy;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.InputQueue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class PhoneWindow extends Window {
    @Override // android.view.Window
    public void addContentView(View r1, ViewGroup.LayoutParams r2) {
    }

    @Override // android.view.Window
    public void closeAllPanels() {
    }

    @Override // android.view.Window
    public void closePanel(int r1) {
    }

    @Override // android.view.Window
    public View getCurrentFocus() {
        return null;
    }

    @Override // android.view.Window
    public View getDecorView() {
        return null;
    }

    @Override // android.view.Window
    public LayoutInflater getLayoutInflater() {
        return null;
    }

    @Override // android.view.Window
    public int getNavigationBarColor() {
        return 0;
    }

    @Override // android.view.Window
    public int getStatusBarColor() {
        return 0;
    }

    @Override // android.view.Window
    public int getVolumeControlStream() {
        return 0;
    }

    @Override // android.view.Window
    public void invalidatePanelMenu(int r1) {
    }

    @Override // android.view.Window
    public boolean isFloating() {
        return false;
    }

    @Override // android.view.Window
    public boolean isShortcutKey(int r1, KeyEvent r2) {
        return false;
    }

    @Override // android.view.Window
    public void onActive() {
    }

    @Override // android.view.Window
    public void onConfigurationChanged(Configuration r1) {
    }

    @Override // android.view.Window
    public void openPanel(int r1, KeyEvent r2) {
    }

    @Override // android.view.Window
    public View peekDecorView() {
        return null;
    }

    @Override // android.view.Window
    public boolean performContextMenuIdentifierAction(int r1, int r2) {
        return false;
    }

    @Override // android.view.Window
    public boolean performPanelIdentifierAction(int r1, int r2, int r3) {
        return false;
    }

    @Override // android.view.Window
    public boolean performPanelShortcut(int r1, int r2, KeyEvent r3, int r4) {
        return false;
    }

    @Override // android.view.Window
    public void restoreHierarchyState(Bundle r1) {
    }

    @Override // android.view.Window
    public Bundle saveHierarchyState() {
        return null;
    }

    @Override // android.view.Window
    public void setBackgroundDrawable(Drawable r1) {
    }

    @Override // android.view.Window
    public void setChildDrawable(int r1, Drawable r2) {
    }

    @Override // android.view.Window
    public void setChildInt(int r1, int r2) {
    }

    @Override // android.view.Window
    public void setContentView(int r1) {
    }

    @Override // android.view.Window
    public void setContentView(View r1) {
    }

    @Override // android.view.Window
    public void setContentView(View r1, ViewGroup.LayoutParams r2) {
    }

    @Override // android.view.Window
    public void setDecorCaptionShade(int r1) {
    }

    @Override // android.view.Window
    public void setFeatureDrawable(int r1, Drawable r2) {
    }

    @Override // android.view.Window
    public void setFeatureDrawableAlpha(int r1, int r2) {
    }

    @Override // android.view.Window
    public void setFeatureDrawableResource(int r1, int r2) {
    }

    @Override // android.view.Window
    public void setFeatureDrawableUri(int r1, Uri r2) {
    }

    @Override // android.view.Window
    public void setFeatureInt(int r1, int r2) {
    }

    @Override // android.view.Window
    public void setNavigationBarColor(int r1) {
    }

    @Override // android.view.Window
    public void setResizingCaptionDrawable(Drawable r1) {
    }

    @Override // android.view.Window
    public void setStatusBarColor(int r1) {
    }

    @Override // android.view.Window
    public void setTitle(CharSequence r1) {
    }

    @Override // android.view.Window
    public void setTitleColor(int r1) {
    }

    @Override // android.view.Window
    public void setVolumeControlStream(int r1) {
    }

    @Override // android.view.Window
    public boolean superDispatchGenericMotionEvent(MotionEvent r1) {
        return false;
    }

    @Override // android.view.Window
    public boolean superDispatchKeyEvent(KeyEvent r1) {
        return false;
    }

    @Override // android.view.Window
    public boolean superDispatchKeyShortcutEvent(KeyEvent r1) {
        return false;
    }

    @Override // android.view.Window
    public boolean superDispatchTouchEvent(MotionEvent r1) {
        return false;
    }

    @Override // android.view.Window
    public boolean superDispatchTrackballEvent(MotionEvent r1) {
        return false;
    }

    @Override // android.view.Window
    public void takeInputQueue(InputQueue.Callback r1) {
    }

    @Override // android.view.Window
    public void takeKeyEvents(boolean r1) {
    }

    @Override // android.view.Window
    public void takeSurface(SurfaceHolder.Callback2 r1) {
    }

    @Override // android.view.Window
    public void togglePanel(int r1, KeyEvent r2) {
    }

    public PhoneWindow(Context r1) {
        super(r1);
    }
}
