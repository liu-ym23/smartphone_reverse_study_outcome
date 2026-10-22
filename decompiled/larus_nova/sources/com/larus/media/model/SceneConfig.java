package com.larus.media.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class SceneConfig {

    @SerializedName("scene_config")
    private List<SceneConfigBean> sceneConfig;

    public static class SceneConfigBean {

        @SerializedName("config")
        private ConfigBean config;

        @SerializedName("scene")
        private String scene;

        public static class ConfigBean {

            @SerializedName("play")
            private MediaActionBean play;

            @SerializedName("record")
            private MediaActionBean record;

            public static class MediaActionBean {

                @SerializedName("can_interrupt_in_peer")
                private boolean canInterruptInPeer;

                @SerializedName("can_mix_with_others")
                private boolean canMixWithOthers;

                @SerializedName("enable")
                private boolean enable;

                @SerializedName("interrupt_priority")
                private int interruptPriority;

                @SerializedName("mix_priority")
                private int mixPriority;

                @SerializedName("should_mix_with_scenes")
                private List<String> shouldMixWithScenes;

                public MediaActionBean() {
                }

                public String toString() {
                    return "MediaActionBean{enable=" + this.enable + ", interruptPriority=" + this.interruptPriority + ", canInterruptInPeer=" + this.canInterruptInPeer + ", canMixWithOthers=" + this.canMixWithOthers + ", mixPriority=" + this.mixPriority + ", shouldMixWithScenes=" + this.shouldMixWithScenes + '}';
                }

                public int getInterruptPriority() {
                    return this.interruptPriority;
                }

                public boolean getIsCanInterruptInPeer() {
                    return this.canInterruptInPeer;
                }

                public int getMixPriority() {
                    return this.mixPriority;
                }

                public boolean getMixWithOthers() {
                    return this.canMixWithOthers;
                }

                public List<String> getShouldMixWithScenes() {
                    return this.shouldMixWithScenes;
                }

                public boolean isEnable() {
                    return this.enable;
                }

                public void setCanInterruptInPeer(boolean r100) {
                    this.canInterruptInPeer = r100;
                }

                public void setCanMixWithOthers(boolean r100) {
                    this.canMixWithOthers = r100;
                }

                public void setEnable(boolean r100) {
                    this.enable = r100;
                }

                public void setInterruptPriority(int r100) {
                    this.interruptPriority = r100;
                }

                public void setMixPriority(int r100) {
                    this.mixPriority = r100;
                }

                public void setShouldMixWithScenes(List<String> r100) {
                    this.shouldMixWithScenes = r100;
                }
            }

            public ConfigBean() {
            }

            public final String toString() {
                return "ConfigBean{record=" + this.record + ", play=" + this.play + '}';
            }

            public final MediaActionBean a() {
                return this.play;
            }

            public final MediaActionBean b() {
                return this.record;
            }
        }

        public SceneConfigBean() {
        }

        public String toString() {
            return "SceneConfigBean{config=" + this.config + ", scene='" + this.scene + "'}";
        }

        public ConfigBean getConfig() {
            return this.config;
        }

        public String getScene() {
            return this.scene;
        }

        public void setConfig(ConfigBean r100) {
            this.config = r100;
        }

        public void setScene(String r100) {
            this.scene = r100;
        }
    }

    public SceneConfig() {
    }

    public List<SceneConfigBean> obtainSceneConfig() {
        return this.sceneConfig;
    }

    public void setSceneConfig(List<SceneConfigBean> r100) {
        this.sceneConfig = r100;
    }
}
