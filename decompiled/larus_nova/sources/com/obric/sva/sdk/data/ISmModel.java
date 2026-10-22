package com.obric.sva.sdk.data;

import com.ss.android.cert.manager.constants.EventConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import r27.a;

/* JADX INFO: loaded from: classes6.dex */
public interface ISmModel {
    public static final String SUFFIX_DEFAULT_SOUND_MODEL = ".uim";
    public static final String SUFFIX_LANGUAGE_MODEL = ".lm";
    public static final String SUFFIX_MERGED_LANGUAGE_MODEL = ".lat";
    public static final String SUFFIX_TRAINED_SOUND_MODEL = ".udm";
    public static final int SVA_SOUND_MODEL_TYPE = 1;
    public static final int UNKNOWN_SOUND_MODEL_TYPE = 0;
    public static final int VERSION_0100 = 256;
    public static final int VERSION_0200 = 512;
    public static final int VERSION_0300 = 768;
    public static final int VERSION_0400 = 1024;
    public static final int VERSION_0500 = 1280;
    public static final int VERSION_0600 = 1536;
    public static final int VERSION_0700 = 1792;
    public static final int VERSION_UNKNOWN = 0;

    public static final enum ModelVersion extends Enum<ModelVersion> {
        private static final /* synthetic */ ModelVersion[] $VALUES = null;
        public static final ModelVersion VERSION_1_0 = null;
        public static final ModelVersion VERSION_2_0 = null;
        public static final ModelVersion VERSION_3_0 = null;
        public static final ModelVersion VERSION_4_0 = null;
        public static final ModelVersion VERSION_5_0 = null;
        public static final ModelVersion VERSION_6_0 = null;
        public static final ModelVersion VERSION_7_0 = null;
        public static final ModelVersion VERSION_UNKNOWN = null;
        private String lable;
        private int number;

        static {
            ModelVersion r100 = new ModelVersion("VERSION_UNKNOWN", 0, "Unknown", 0);
            VERSION_UNKNOWN = r100;
            ModelVersion r101 = new ModelVersion("VERSION_1_0", 1, "1.0", 1);
            VERSION_1_0 = r101;
            ModelVersion r102 = new ModelVersion("VERSION_2_0", 2, EventConstant.Value.AUTH_VERSION_2, 2);
            VERSION_2_0 = r102;
            ModelVersion r103 = new ModelVersion("VERSION_3_0", 3, "3.0", 3);
            VERSION_3_0 = r103;
            ModelVersion r104 = new ModelVersion("VERSION_4_0", 4, "4.0", 4);
            VERSION_4_0 = r104;
            ModelVersion r105 = new ModelVersion("VERSION_5_0", 5, "5.0", 5);
            VERSION_5_0 = r105;
            ModelVersion r110 = new ModelVersion("VERSION_6_0", 6, "6.0", 6);
            VERSION_6_0 = r110;
            ModelVersion r111 = new ModelVersion("VERSION_7_0", 7, "7.0", 7);
            VERSION_7_0 = r111;
            $VALUES = new ModelVersion[]{r100, r101, r102, r103, r104, r105, r110, r111};
        }

        public static ModelVersion[] values() {
            return (ModelVersion[]) $VALUES.clone();
        }

        public String getLable() {
            return this.lable;
        }

        public int getVersionNumber() {
            return this.number;
        }

        public static ModelVersion valueOf(String r100) {
            return (ModelVersion) a.a(ModelVersion.class, r100);
        }

        private ModelVersion(String r100, int r101, String r102, int r103) {
            super(r100, r101);
            this.lable = r102;
            this.number = r103;
        }
    }

    void addKeyphrase(String r100, int r101);

    void addKeyphraseAndUser(String r100, int r101, String r102, int r103);

    boolean canAddUser();

    ArrayList<IUserModel> getAllUsers();

    IKeyphraseModel getKeyphraseModel(String r100);

    String getKeyphraseNameById(int r100);

    String getSoundModelFullFileName();

    List<IKeyphraseModel> getSoundModelKeyphraseList();

    String getSoundModelPrettyFileName();

    String getSoundModelPrettyKeyphrase();

    String getSoundModelSuffix();

    int getSoundModelType();

    UUID getSoundModelUUID();

    ModelVersion getSoundModelVersion();

    boolean isSupportExtendedOpaqueData();

    boolean isUdkSm();

    boolean isUserExistForKeyphrase(String r100, String r101);

    boolean isUserTrainedSoundModel();

    void removeKeyphrase(String r100);

    void removeUser(String r100, String r101);

    void setSoundModelFullFileName(String r100);

    void setSoundModelPrettyFileName(String r100);

    void setSoundModelPrettyKeyphrase(String r100);

    void setSoundModelSuffix(String r100);

    void setSoundModelType(int r100);

    void setSoundModelVersion(ModelVersion r100);
}
