package com.bytedance.ee.bear.mindnote.setting;

import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
class MindNoteSettingData implements NonProguard {
    private String activeStructureKey;
    private String activeThemeKey;
    private List<StructureItem> structures;
    private List<ThemeItem> themes;

    public String toString() {
        return "MindNoteSettingData{activeStructureKey='" + this.activeStructureKey + "', activeThemeKey='" + this.activeThemeKey + "', structures=" + this.structures + ", themes=" + this.themes + '}';
    }

    public MindNoteSettingData() {
        this.structures = new ArrayList();
        this.themes = new ArrayList();
    }

    public String getActiveStructureKey() {
        return this.activeStructureKey;
    }

    public String getActiveThemeKey() {
        return this.activeThemeKey;
    }

    public List<StructureItem> getStructures() {
        return this.structures;
    }

    public List<ThemeItem> getThemes() {
        return this.themes;
    }

    public void setActiveStructureKey(String r100) {
        this.activeStructureKey = r100;
    }

    public void setActiveThemeKey(String r100) {
        this.activeThemeKey = r100;
    }

    public void setStructures(List<StructureItem> r100) {
        this.structures = r100;
    }

    public void setThemes(List<ThemeItem> r100) {
        this.themes = r100;
    }
}
