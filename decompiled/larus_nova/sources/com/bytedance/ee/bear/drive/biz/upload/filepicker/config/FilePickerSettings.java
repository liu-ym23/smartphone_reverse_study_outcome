package com.bytedance.ee.bear.drive.biz.upload.filepicker.config;

import r27.a;

/* JADX INFO: loaded from: classes16.dex */
public final enum FilePickerSettings extends Enum<FilePickerSettings> {
    public static final FilePickerSettings SETTINGS_SHOW_DIRS_FIRST = null;
    public static final FilePickerSettings SETTINGS_SHOW_HIDDEN = null;
    public static final FilePickerSettings SETTINGS_SHOW_SYMLINKS = null;
    public static final FilePickerSettings SETTINGS_SHOW_SYSTEM = null;
    public static final FilePickerSettings SETTINGS_SORT_MODE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FilePickerSettings[] f223880a = null;
    private final Object mDefaultValue;
    private final String mId;

    static {
        FilePickerSettings r100 = new FilePickerSettings("SETTINGS_SORT_MODE", 0, "sort_mode", NavigationSortMode.NAME_ASC);
        SETTINGS_SORT_MODE = r100;
        FilePickerSettings r101 = new FilePickerSettings("SETTINGS_SHOW_DIRS_FIRST", 1, "show_dirs_first", Boolean.TRUE);
        SETTINGS_SHOW_DIRS_FIRST = r101;
        Boolean r102 = Boolean.FALSE;
        FilePickerSettings r103 = new FilePickerSettings("SETTINGS_SHOW_HIDDEN", 2, "show_hidden", r102);
        SETTINGS_SHOW_HIDDEN = r103;
        FilePickerSettings r104 = new FilePickerSettings("SETTINGS_SHOW_SYSTEM", 3, "show_system", r102);
        SETTINGS_SHOW_SYSTEM = r104;
        FilePickerSettings r105 = new FilePickerSettings("SETTINGS_SHOW_SYMLINKS", 4, "show_symlinks", r102);
        SETTINGS_SHOW_SYMLINKS = r105;
        f223880a = new FilePickerSettings[]{r100, r101, r103, r104, r105};
    }

    public static FilePickerSettings[] values() {
        return (FilePickerSettings[]) f223880a.clone();
    }

    public Object getDefaultValue() {
        return this.mDefaultValue;
    }

    public String getId() {
        return this.mId;
    }

    public static FilePickerSettings valueOf(String r100) {
        return (FilePickerSettings) a.a(FilePickerSettings.class, r100);
    }

    public FilePickerSettings(String r100, int r101, String r102, Object r103) {
        super(r100, r101);
        this.mId = r102;
        this.mDefaultValue = r103;
    }
}
