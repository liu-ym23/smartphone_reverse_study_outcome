package com.obric.security.agentmanager;

/* JADX INFO: loaded from: classes6.dex */
public class AgentProof {
    private byte[] agentData;
    private byte[] agentHash;
    private String agentUuid;
    private byte[] certChain;
    private byte[] deviceStatus;
    private byte[] signature;

    public byte[] getAgentData() {
        throw new RuntimeException("Stub!!");
    }

    public byte[] getAgentHash() {
        throw new RuntimeException("Stub!!");
    }

    public String getAgentUuid() {
        throw new RuntimeException("Stub!!");
    }

    public byte[] getCertChain() {
        throw new RuntimeException("Stub!!");
    }

    public byte[] getDeviceStatus() {
        throw new RuntimeException("Stub!!");
    }

    public byte[] getSignature() {
        throw new RuntimeException("Stub!!");
    }

    public void setAgentData(byte[] r100) {
        throw new RuntimeException("Stub!!");
    }

    public void setAgentHash(byte[] r100) {
        throw new RuntimeException("Stub!!");
    }

    public void setAgentUuid(String r100) {
        throw new RuntimeException("Stub!!");
    }

    public void setCertChain(byte[] r100) {
        throw new RuntimeException("Stub!!");
    }

    public void setDeviceStatus(byte[] r100) {
        throw new RuntimeException("Stub!!");
    }

    public void setSignature(byte[] r100) {
        throw new RuntimeException("Stub!!");
    }

    public AgentProof(String r100, byte[] r101, byte[] r102, byte[] r103, byte[] r104, byte[] r105) {
        this.agentUuid = r100;
        this.agentData = r101;
        this.agentHash = r102;
        this.deviceStatus = r103;
        this.certChain = r104;
        this.signature = r105;
    }
}
