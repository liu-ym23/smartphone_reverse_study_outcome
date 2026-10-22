package d3;

import com.bytedance.ai.bridge.ContainerType;

/* JADX INFO: loaded from: classes43.dex */
public abstract class a0 {
    private final String appId;
    private final Integer appSourceType;
    private final String appletId;
    private final String containerId;
    private final ContainerType containerType;
    private final String conversationId;
    private final String path;
    private final String tag;
    private final Long traceId;
    private final String url;

    public a0() {
        this.containerType = ContainerType.NONE;
        this.containerId = "";
    }

    public String getAppId() {
        return this.appId;
    }

    public Integer getAppSourceType() {
        return this.appSourceType;
    }

    public String getAppletId() {
        return this.appletId;
    }

    public String getContainerId() {
        return this.containerId;
    }

    public ContainerType getContainerType() {
        return this.containerType;
    }

    public String getConversationId() {
        return this.conversationId;
    }

    public String getPath() {
        return this.path;
    }

    public String getTag() {
        return this.tag;
    }

    public Long getTraceId() {
        return this.traceId;
    }

    public String getUrl() {
        return this.url;
    }
}
