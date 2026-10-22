package com.bytedance.ee.bear.mindnote.setting;

import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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

    public void setActiveStructureKey(String r1) {
        this.activeStructureKey = r1;
    }

    public void setActiveThemeKey(String r1) {
        this.activeThemeKey = r1;
    }

    public void setStructures(List<StructureItem> r1) {
        this.structures = r1;
    }

    public void setThemes(List<ThemeItem> r1) {
        this.themes = r1;
    }
}
