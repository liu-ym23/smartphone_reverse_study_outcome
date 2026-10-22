package com.lynx.markdown;

/* JADX INFO: loaded from: classes32.dex */
public interface IMarkdownViewHandle {
    void align(int r100, int r101);

    long getPosition();

    long getSize();

    int getVerticalAlign();

    long measure(int r100, int r101, int r102, int r103);

    void requestAlign();

    void requestDraw();

    void requestMeasure();

    void setPosition(int r100, int r101);

    void setSize(int r100, int r101);

    void setVisibility(boolean r100);
}
