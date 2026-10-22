package com.bytedance.ee.bear.drive.biz.upload.filepicker.config;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final enum FilePickerSettings extends Enum<FilePickerSettings> {
    public static final FilePickerSettings SETTINGS_SHOW_DIRS_FIRST = null;
    public static final FilePickerSettings SETTINGS_SHOW_HIDDEN = null;
    public static final FilePickerSettings SETTINGS_SHOW_SYMLINKS = null;
    public static final FilePickerSettings SETTINGS_SHOW_SYSTEM = null;
    public static final FilePickerSettings SETTINGS_SORT_MODE = null;
    public static final /* synthetic */ FilePickerSettings[] a = null;
    private final Object mDefaultValue;
    private final String mId;

    static {
        FilePickerSettings r0 = new FilePickerSettings("SETTINGS_SORT_MODE", 0, "sort_mode", NavigationSortMode.NAME_ASC);
        SETTINGS_SORT_MODE = r0;
        FilePickerSettings r1 = new FilePickerSettings("SETTINGS_SHOW_DIRS_FIRST", 1, "show_dirs_first", Boolean.TRUE);
        SETTINGS_SHOW_DIRS_FIRST = r1;
        Boolean r3 = Boolean.FALSE;
        FilePickerSettings r2 = new FilePickerSettings("SETTINGS_SHOW_HIDDEN", 2, "show_hidden", r3);
        SETTINGS_SHOW_HIDDEN = r2;
        FilePickerSettings r5 = new FilePickerSettings("SETTINGS_SHOW_SYSTEM", 3, "show_system", r3);
        SETTINGS_SHOW_SYSTEM = r5;
        FilePickerSettings r8 = new FilePickerSettings("SETTINGS_SHOW_SYMLINKS", 4, "show_symlinks", r3);
        SETTINGS_SHOW_SYMLINKS = r8;
        a = new FilePickerSettings[]{r0, r1, r2, r5, r8};
    }

    public static FilePickerSettings[] values() {
        return (FilePickerSettings[]) a.clone();
    }

    public Object getDefaultValue() {
        return this.mDefaultValue;
    }

    public String getId() {
        return this.mId;
    }

    public static FilePickerSettings valueOf(String r1) {
        return (FilePickerSettings) a.a(FilePickerSettings.class, r1);
    }

    public FilePickerSettings(String r1, int r2, String r3, Object r4) {
        super(r1, r2);
        this.mId = r3;
        this.mDefaultValue = r4;
    }
}
