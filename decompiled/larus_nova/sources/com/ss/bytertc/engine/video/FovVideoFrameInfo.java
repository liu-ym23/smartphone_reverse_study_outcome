package com.ss.bytertc.engine.video;

import java.util.HashMap;

/* JADX INFO: loaded from: classes40.dex */
public class FovVideoFrameInfo {
    private int destColumn;
    private int destRow;
    private int hdColumn;
    private int hdHeight;
    private int hdRow;
    private int hdWidth;
    private int ldColumn;
    private int ldHeight;
    private int ldRow;
    private int ldWidth;
    private int tileHeight;
    private HashMap<Short, Short> tileMap;
    private int tileWidth;

    public static FovVideoFrameInfo genFovVideoFrameInfo() {
        return new FovVideoFrameInfo();
    }

    public FovVideoFrameInfo() {
        this.tileMap = new HashMap();
    }

    public int getDestColumn() {
        return this.destColumn;
    }

    public int getDestRow() {
        return this.destRow;
    }

    public int getHdColumn() {
        return this.hdColumn;
    }

    public int getHdHeight() {
        return this.hdHeight;
    }

    public int getHdRow() {
        return this.hdRow;
    }

    public int getHdWidth() {
        return this.hdWidth;
    }

    public int getLdColumn() {
        return this.ldColumn;
    }

    public int getLdHeight() {
        return this.ldHeight;
    }

    public int getLdRow() {
        return this.ldRow;
    }

    public int getLdWidth() {
        return this.ldWidth;
    }

    public int getTileHeight() {
        return this.tileHeight;
    }

    public HashMap<Short, Short> getTileMap() {
        return this.tileMap;
    }

    public int getTileWidth() {
        return this.tileWidth;
    }

    private void setDestColumn(int r100) {
        this.destColumn = r100;
    }

    private void setDestRow(int r100) {
        this.destRow = r100;
    }

    private void setHdColumn(int r100) {
        this.hdColumn = r100;
    }

    private void setHdHeight(int r100) {
        this.hdHeight = r100;
    }

    private void setHdRow(int r100) {
        this.hdRow = r100;
    }

    private void setHdWidth(int r100) {
        this.hdWidth = r100;
    }

    private void setLdColumn(int r100) {
        this.ldColumn = r100;
    }

    private void setLdHeight(int r100) {
        this.ldHeight = r100;
    }

    private void setLdRow(int r100) {
        this.ldRow = r100;
    }

    private void setLdWidth(int r100) {
        this.ldWidth = r100;
    }

    private void setTileHeight(int r100) {
        this.tileHeight = r100;
    }

    private void setTileWidth(int r100) {
        this.tileWidth = r100;
    }

    private void putTileMapValue(short r100, short r101) {
        this.tileMap.put(Short.valueOf(r100), Short.valueOf(r101));
    }
}
