package com.google.android.flexbox;

import android.view.View;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public interface a {
    void b(b r100);

    View d(int r100);

    int getAlignContent();

    int getAlignItems();

    int getFlexDirection();

    int getFlexItemCount();

    List<b> getFlexLinesInternal();

    int getFlexWrap();

    int getLargestMainSize();

    int getMaxLine();

    int getPaddingBottom();

    int getPaddingEnd();

    int getPaddingLeft();

    int getPaddingRight();

    int getPaddingStart();

    int getPaddingTop();

    int getSumOfCrossSize();

    int h(View r100);

    int i(View r100, int r101, int r102);

    void j(View r100, int r101, int r102, b r103);

    int k(int r100, int r101, int r102);

    View l(int r100);

    int m(int r100, int r101, int r102);

    void n(int r100, View r101);

    boolean o();

    void setFlexLines(List<b> r100);
}
